package eu.caimandesign.gwt.lib.presenter.client.place;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;


public class HistoryClientApi implements HistoryApi {

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return History.addValueChangeHandler(handler);
	}

	@Override
	public String getToken() {
		return History.getToken();
	}

	@Override
	public void newItem(String historyToken, boolean issueEvent) {
		History.newItem(historyToken, issueEvent);
	}

	@Override
	public void fireCurrentHistoryState() {
		History.fireCurrentHistoryState();
	}

}
