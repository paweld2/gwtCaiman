package pmsoft.gwt.sample.server;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.servlet.SessionScoped;
import net.customware.gwt.dispatch.server.secure.ScopedSession;
import net.customware.gwt.dispatch.server.secure.SecureSession;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import javax.servlet.http.HttpSession;

public class ServerSessionModule extends AbstractModule {

    private static class TestSecureSession implements SecureSession{
        private boolean login = false;

        private final HttpSession session;

        @Inject
        private TestSecureSession(HttpSession session) {
            this.session = session;
        }

        @Override
        public boolean validate(String sessionId) {
            return session.getId() == sessionId;
        }

        @Override
        public String getSessionId() {
            return null;
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

    private static class TestScopedSession implements ScopedSession {
        private final Provider<SecureSession> sessionProvider;

        @Inject
        private TestScopedSession(Provider<SecureSession> sessionProvider) {
            this.sessionProvider = sessionProvider;
        }

        @Override
        public SecureSession getSession() {
            return sessionProvider.get();
        }
    }

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
        bind(ScopedSession.class).to(TestScopedSession.class);
        bind(SecureSession.class).to(TestSecureSession.class).in(SessionScoped.class);
    }

}
