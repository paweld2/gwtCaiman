package pmsoft.gwt.sample.server.handlers;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;
import pmsoft.gwt.sample.shared.ar.LoginAction;
import pmsoft.gwt.sample.shared.ar.PingAction;

public class AppActionHandlerModule extends ActionHandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler(PingAction.class, PingHandler.class);
		bindHandler(LoginAction.class, LoginHandler.class);
	}

}
