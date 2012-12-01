package pmsoft.gwt.sample.shared.inject;

import pmsoft.gwt.sample.shared.flow.login.LoginDisplayFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginPresenterFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationDisplayFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationPresenterFlow;
import pmsoft.gwt.sample.shared.logic.display.LoginDisplay;
import pmsoft.gwt.sample.shared.logic.display.NavigationDisplay;
import pmsoft.gwt.sample.shared.logic.presenter.LoginPresenter;
import pmsoft.gwt.sample.shared.logic.presenter.NavigationPresenter;
import eu.caimandesign.gwt.lib.presenter.client.api.flow.AbstractPresenterFlowModule;

public class AppPresenterModule extends AbstractPresenterFlowModule {

	@Override
	protected void configure() {
		bindPresenter(LoginPresenterFlow.class, LoginPresenter.class, LoginDisplayFlow.class, LoginDisplay.class);
		bindPresenter(NavigationPresenterFlow.class,NavigationPresenter.class,NavigationDisplayFlow.class,NavigationDisplay.class);
	}

}
