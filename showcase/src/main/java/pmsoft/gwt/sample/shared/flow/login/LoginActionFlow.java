package pmsoft.gwt.sample.shared.flow.login;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.ActionFlow;

public interface LoginActionFlow extends
		ActionFlow<LoginPresenterFlow, LoginDisplayFlow, LoginActionFlow> {

	public void loginUser(String username, String password);

}
