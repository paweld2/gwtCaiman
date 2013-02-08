package pmsoft.gwt.sample.server.handlers;

import net.customware.gwt.dispatch.server.AbstractActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.secure.ScopedSession;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import pmsoft.gwt.sample.shared.ar.LoginAction;
import pmsoft.gwt.sample.shared.ar.LoginResult;

import com.google.inject.Inject;

public class LoginHandler extends AbstractActionHandler<LoginAction, LoginResult> {

	private final ScopedSession scopedSession;

	@Inject
	public LoginHandler(ScopedSession scopedSession) {
		super(LoginAction.class);
		this.scopedSession = scopedSession;
	}

	@Override
	public LoginResult execute(LoginAction action, ExecutionContext context)
			throws ActionException {
		scopedSession.getSession().login();
		return new LoginResult();
	}

	@Override
	public void rollback(LoginAction action, LoginResult result,
			ExecutionContext context) throws ActionException {
		scopedSession.getSession().logout();
	}

}
