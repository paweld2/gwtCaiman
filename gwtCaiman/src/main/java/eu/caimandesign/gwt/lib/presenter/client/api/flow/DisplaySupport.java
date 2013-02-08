package eu.caimandesign.gwt.lib.presenter.client.api.flow;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;

public interface DisplaySupport<A> {
	public void setupActionFlow(A action);
	public void show(AcceptsOneWidget panel,ActivityController activityContext);
}
