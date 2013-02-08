package pmsoft.gwt.sample.shared.flow;

import pmsoft.gwt.sample.shared.flow.login.LoginActionFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginDisplayFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginPresenterFlow;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.AbstractFlowContract;

public class LoginFlow extends AbstractFlowContract<LoginPresenterFlow, LoginDisplayFlow, LoginActionFlow> {

	@Inject
	public LoginFlow(Provider<LoginPresenterFlow> presenterProvider, Provider<LoginDisplayFlow> displayProvider) {
		super(presenterProvider, displayProvider);
	}

}
