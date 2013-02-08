package eu.caimandesign.gwt.lib.presenter.client.place;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public interface HistoryApi {

	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler);

	public String getToken();

	public void newItem(String historyToken, boolean issueEvent);

	public void fireCurrentHistoryState();

}
