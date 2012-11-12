package eu.caimandesign.gwt.lib.presenter.client.place;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;
import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityMachine;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanActivity;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.PlaceRegistry;

public class DefaultPlaceManager implements PlaceManager {
	private class PlaceEventHandler implements ValueChangeHandler<String>,
			PlaceRevealedHandler, PlaceChangedHandler {

		private PlaceController currentPlaceActive = null;

		public void onPlaceRevealed(PlaceRevealedEvent event) {
			PlaceController newplace = event.getPlace();
			logger.fine("place revealed event to " + newplace);
			if (currentPlaceActive != null && !currentPlaceActive.equals(newplace)) {
				currentPlaceActive.stopWork();
			}
			currentPlaceActive = newplace;
			updateHistory(newplace);
		}

		public void onPlaceChanged(PlaceChangedEvent event) {
			PlaceController place = event.getPlace();
			try {
				if (place.matchesRequest(tokenFormatter.toPlaceRequest(history
						.getToken()))) {
					// Only update if the change comes from a place that matches
					// the current location.
					updateHistory(event.getPlace());
				}
			} catch (TokenFormatException e) {
				// Do nothing...
			}
		}

		/**
		 * Handles change events from {@link HistoryApi}.
		 */
		public void onValueChange(ValueChangeEvent<String> event) {
			try {
				PlaceRequestEvent.fire(eventBus,
						tokenFormatter.toPlaceRequest(event.getValue()), true);
			} catch (TokenFormatException e) {
				e.printStackTrace();
			}
		}

	}

	private final Logger logger = CaimanLogging.getLogger();

	private final EventBus eventBus;

	private final TokenFormatter tokenFormatter;

	private final Map<Class<? extends CaimanPlace>, PlaceController> placeMap;

	private PlaceController defaultPlaceController;

	private final Provider<PlaceController> providerPlaceController;

	private final HistoryApi history;
	private final ActivityMachine activityMachine;

	@Inject
	public DefaultPlaceManager(EventBus eventBus,
			TokenFormatter tokenFormatter, PlaceRegistry placeRegistry,
			Provider<PlaceController> providerPlaceController,
			HistoryApi history,
			ActivityMachine activityMachine) {
		this.activityMachine = activityMachine;
		this.eventBus = eventBus;
		this.tokenFormatter = tokenFormatter;
		this.providerPlaceController = providerPlaceController;
		this.history = history;
		logger.config("starting....");
		PlaceEventHandler handler = new PlaceEventHandler();

		// Register ourselves with the History API.
		this.history.addValueChangeHandler(handler);

		// Listen for manual place change events.
		eventBus.addHandler(PlaceChangedEvent.getType(), handler);

		// Listen for place revelation requests.
		eventBus.addHandler(PlaceRevealedEvent.getType(), handler);

		placeMap = new HashMap<Class<? extends CaimanPlace>, PlaceController>();

		placeRegistry.loadPlaceOnManager(this);

	}

	@Override
	public void fireActivity(CaimanActivity activity) {
		activityMachine.pushActivity(activity);
		ActivityController current = activityMachine.peekActivity();
		logger.fine("top activity is " + current);
		PlaceRequestEvent.fire(eventBus, getController(current.getActivityPlace()).createRequest());
	}
	
	private PlaceController getController(Class<? extends CaimanPlace> placeClass) {
		if( placeClass == null) {
			return defaultPlaceController;
		}
		if( !placeMap.containsKey(placeClass)) logger.log( Level.SEVERE,"Place class not registered" + placeClass);
		return placeMap.get(placeClass);
	}

	@Override
	public void setDefaultPlace(CaimanPlace defaultPlace) {
		registerPlace(defaultPlace);
		this.defaultPlaceController = placeMap.get(defaultPlace.getClass());
		logger.config("Default place set to " + defaultPlace.getClass().getName());

	}

	@Override
	public boolean registerPlace(CaimanPlace place) {
		if (!placeMap.containsKey(place.getClass())) {
			PlaceController controller = providerPlaceController.get();
			controller.setPlaceLogic(place);
			controller.addHandlers(eventBus);
			placeMap.put(place.getClass(), controller);
			logger.config("Registered place " + place.getClass().getName());
			return true;
		}
		return false;
	}

	@Deprecated
	public boolean deregisterPlace(PlaceController place) {
		if (!placeMap.containsKey(place.getClass())) {
			place.removeHandlers(eventBus);
			placeMap.remove(place.getClass());
			logger.config("Deregistered place " + place.getClass().getName());
			return true;
		}
		return false;
	}

	private void updateHistory(PlaceController place) {
		updateHistory(place.createRequest());
	}

	// Updates History if it has changed, without firing another
	// 'ValueChangeEvent'.
	private void updateHistory(PlaceRequest request) {
		try {
			String requestToken = tokenFormatter.toHistoryToken(request);
			String historyToken = history.getToken();
			if (historyToken == null || !historyToken.equals(requestToken)) {
				history.newItem(requestToken, false);
				logger.config("update history to place [" + request.getName() + "]");
			}

		} catch (TokenFormatException e) {
			// Do nothing.
			logger.log(Level.WARNING, "error on token load", e);
		}
	}

	/**
	 * Fires a {@link PlaceRequestEvent} with the current history token, if
	 * present. If no history token is set, default place is fired
	 * 
	 * @return <code>true</code>
	 */
	public boolean fireCurrentPlace() {
		String current = history.getToken();
		if (current != null && current.trim().length() > 0) {
			history.fireCurrentHistoryState();
			return true;
		}
		PlaceRequestEvent.fire(eventBus, defaultPlaceController.createRequest());
		return true;
	}
}
