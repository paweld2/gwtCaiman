package pmsoft.gwt.sample.shared.flow.login;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.DisplayFlow;

public interface LoginDisplayFlow extends
		DisplayFlow<LoginPresenterFlow, LoginDisplayFlow, LoginActionFlow> {

	public void setError(String error);

}