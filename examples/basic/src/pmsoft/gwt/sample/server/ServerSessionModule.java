package pmsoft.gwt.sample.server;

import net.customware.gwt.dispatch.server.secure.ScopedSession;
import net.customware.gwt.dispatch.server.secure.SecureSession;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.AbstractModule;

public class ServerSessionModule extends AbstractModule {

	@Override
	protected void configure() {
		//FIXME diuplicated config
		bind(SecureSessionValidator.class).toInstance(
				new SecureSessionValidator() {
					@Override
					public boolean isValid(String sessionId,
							SecureSession session) {
						return session.validate(sessionId);
					}
				});
		bind(ScopedSession.class).toInstance(new ScopedSession() {
			SecureSession session = new SecureSession() {
				private String sid = "randomSessionId";
				private boolean login = false;

				@Override
				public boolean validate(String sessionId) {
					if (sid == null || sessionId == null) {
						return false;
					}
					return sid.compareTo(sessionId) == 0;
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
