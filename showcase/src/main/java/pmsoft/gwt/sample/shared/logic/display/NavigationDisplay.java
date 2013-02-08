package pmsoft.gwt.sample.shared.logic.display;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationActionFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationDisplayFlow;

public class NavigationDisplay implements NavigationDisplayFlow {

	protected NavigationActionFlow action;

	@Override
	public void setupActionFlow(NavigationActionFlow action) {
		this.action = action;
	}
	@Override
	public void show(AcceptsOneWidget panel, ActivityController activityContext) {
		// TODO Auto-generated method stub
		
	}

}
