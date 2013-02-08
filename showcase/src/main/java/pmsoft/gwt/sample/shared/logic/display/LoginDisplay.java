package pmsoft.gwt.sample.shared.logic.display;

import pmsoft.gwt.sample.shared.flow.login.LoginActionFlow;
import pmsoft.gwt.sample.shared.flow.login.LoginDisplayFlow;
import pmsoft.gwt.sample.shared.ui.view.LoginView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewEvent;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewHandler;

public class LoginDisplay implements LoginDisplayFlow {

	protected LoginActionFlow action;

	@Inject
	private Provider<LoginView> loginView;

	@Override
	public void setupActionFlow(LoginActionFlow action) {
		this.action = action;
	}

	@Override
	public void show(AcceptsOneWidget panel, ActivityController activityContext) {
		final LoginView view = loginView.get();
		activityContext.match(view.onLoginAction(),new ViewHandler() {
			@Override
			public void onDisplayEvent(ViewEvent event) {
				action.loginUser(view.getUsername(), view.getPassword());
			}
		});
		panel.setWidget(view);
	}

	@Override
	public void setError(String error) {
		loginView.get().setErrorMessage(error);			
	}

}
