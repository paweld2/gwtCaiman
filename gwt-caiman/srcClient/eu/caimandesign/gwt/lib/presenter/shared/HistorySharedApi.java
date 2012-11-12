package eu.caimandesign.gwt.lib.presenter.shared;

import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;
import eu.caimandesign.gwt.lib.presenter.client.place.HistoryApi;

public class HistorySharedApi implements HistoryApi,
		HasValueChangeHandlers<String> {

	private final Logger logger = CaimanLogging.getLogger();

	private String token = null;
	private HandlerManager handlers = new HandlerManager(null);

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return handlers.addHandler(ValueChangeEvent.getType(), handler);
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlers.fireEvent(event);
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void newItem(String historyToken, boolean issueEvent) {
		historyToken = (historyToken == null) ? "" : historyToken;
		if (!historyToken.equals(getToken())) {
			setToken(historyToken);
			if (issueEvent) {
				fireHistoryChangedImpl(historyToken);
			}
		}
	}

	private void setToken(String historyToken) {
		logger.fine("token set to [" + historyToken + "]");
		token = historyToken;
	}

	public void fireHistoryChangedImpl(String newToken) {
		logger.fine("token:" + newToken);
		ValueChangeEvent.fire(this, newToken);
	}

	@Override
	public void fireCurrentHistoryState() {
		String token = getToken();
		this.fireHistoryChangedImpl(token);
	}

}
