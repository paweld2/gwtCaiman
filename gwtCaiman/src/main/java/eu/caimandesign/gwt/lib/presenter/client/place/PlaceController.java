package eu.caimandesign.gwt.lib.presenter.client.place;

import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;
import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityMachine;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.Layout;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.RootLayout;

public class PlaceController {
	private final Logger logger = CaimanLogging.getLogger();

	private final ActivityMachine activityContext;
	private final RootLayout rootLayout;

	@Inject
	public PlaceController(ActivityMachine activityContext,RootLayout rootLayout) {
		super();
		this.activityContext = activityContext;
		this.rootLayout = rootLayout;
	}

	private CaimanPlace placeLogic;

	// TODO assited
	public void setPlaceLogic(CaimanPlace placeLogic) {
		this.placeLogic = placeLogic;
	}

	public String getName() {
		String fullName = placeLogic.getClass().getName();
		return fullName.substring(fullName.lastIndexOf(".")+1);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PlaceController) {
			PlaceController place = (PlaceController) o;
			return getName().equals(place.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 17 * getName().hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

	private ActivityController currentActivityContext = null;

	/**
	 * This method is called when a matching request is received.
	 * 
	 * @param request
	 *            The place request.
	 */
	protected boolean handleRequest(PlaceRequest request) {
		ActivityController topActivity = activityContext.peekActivity();
		if(topActivity == currentActivityContext) {
			return false;
		}
		currentActivityContext = topActivity;
		Layout layout = placeLogic.setupLayout(currentActivityContext);
		if (layout == null) {
			logger.info("no layout returned on " + getName());
			throw new RuntimeException("no layout on place " + getName() );
//			return false;
		}
		logger.fine("binding layout to RootLayout");
		HasWidgets rootPanel = rootLayout.getRootPanel();
		rootPanel.clear();
		rootPanel.add(layout.getContent());
		logger.info("starting activity on place" + getName());
		currentActivityContext.startActivity();
		return true;
	}

	public void stopWork() {
		// FIXME is this hook necessary???
		logger.info("the place bind must be unactiveded. Now I dont see any bind active to delete.");
//		if (currentActivityContext != null) {
//			logger.info("stoping activity on place" + getName());
//			currentActivityContext.stopActivity();
//		}
//		currentActivityContext = null;
	}

	public boolean matchesRequest(PlaceRequest request) {
		return getName().equals(request.getName());
	}

	public PlaceRequest createRequest() {
		return prepareRequest(new PlaceRequest(getName()));
	}

	protected PlaceRequest prepareRequest(PlaceRequest request) {
		return request;
	}

	private HandlerRegistration placeRequestRegistration;

	public void addHandlers(final EventBus eventBus) {
		placeRequestRegistration = eventBus.addHandler(
				PlaceRequestEvent.getType(), new PlaceRequestHandler() {
					public void onPlaceRequest(PlaceRequestEvent event) {
						PlaceRequest request = event.getRequest();
						if (matchesRequest(request)) {
							boolean handleOk = handleRequest(request);
							if (handleOk) {
								eventBus.fireEvent(new PlaceRevealedEvent(
										PlaceController.this));
							}
						}
					}
				});
	}

	public void removeHandlers(EventBus eventBus) {
		if (placeRequestRegistration != null) {
			placeRequestRegistration.removeHandler();
			placeRequestRegistration = null;
		}
	}

}
