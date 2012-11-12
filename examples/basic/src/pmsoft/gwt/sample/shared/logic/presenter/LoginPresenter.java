package pmsoft.gwt.sample.shared.logic.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import pmsoft.gwt.sample.shared.ar.LoginAction;
import pmsoft.gwt.sample.shared.ar.LoginResult;
import pmsoft.gwt.sample.shared.flow.login.LoginActionFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginDisplayFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginPresenterFlow;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class LoginPresenter implements LoginPresenterFlow, LoginActionFlow {

	private final DispatchAsync dispatcher;
	
	protected final LoginDisplayFlow display;

	@Inject
	public LoginPresenter(LoginDisplayFlow display,DispatchAsync dispatcher) {
		super();
		this.display = display;
		this.dispatcher = dispatcher;
	}

	@Override
	public LoginActionFlow getActionFlow() {
		return this;
	}

	@Override
	public LoginDisplayFlow getDisplay() {
		return display;
	}

	@Override
	public void loginUser(String username, String password) {
		dispatcher.execute(new LoginAction(), new AsyncCallback<LoginResult>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}
			@Override
			public void onSuccess(LoginResult result) {
				if( ! result.ok) {
					display.setError(result.error);	
				} else {
					throw new RuntimeException("unimplemented");
				}
			}
		});
		
//		return "non implemented yet";
	}

}
