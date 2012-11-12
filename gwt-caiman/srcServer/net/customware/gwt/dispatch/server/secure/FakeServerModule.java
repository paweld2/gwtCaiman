package net.customware.gwt.dispatch.server.secure;

import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.server.guice.SecureDispatchServlet;

import com.google.inject.AbstractModule;

public class FakeServerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SecureDispatchService.class).to(SecureDispatchServlet.class)
				.asEagerSingleton();
		bind(SecureSessionValidator.class).toInstance(new SecureSessionValidator() {
			@Override
			public boolean isValid(String sessionId, SecureSession session) {
				return session.validate(sessionId);
			}
		});
		bind(ScopedSession.class).toInstance(new ScopedSession() {
			SecureSession session = new SecureSession() {
				private String sid = "randomSessionId";
				private boolean login = false;
				@Override
				public boolean validate(String sessionId) {
					if( sid == null || sessionId == null) {
						return false;
					}
					return sid.compareTo(sessionId)==0;
				}
				@Override
				public String getSessionId() {
					return sid;
				}
				@Override
				public void login() {
					login = true;					
				}
				@Override
				public void logout() {
					login = false;
				}
				@Override
				public boolean isUserLogin() {
					return login;
				}
			};
			@Override
			public SecureSession getSession() {
				return session;
			}
		});
	}

}
