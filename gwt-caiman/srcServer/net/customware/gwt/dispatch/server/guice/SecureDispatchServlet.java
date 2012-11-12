package net.customware.gwt.dispatch.server.guice;

import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.secure.ScopedSession;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;
import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import net.customware.gwt.dispatch.shared.ar.Result;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SecureDispatchServlet extends RemoteServiceServlet implements SecureDispatchService {

	private static final long serialVersionUID = 5224793233561737086L;

	private final Dispatch dispatch;

    private final SecureSessionValidator sessionValidator;
    
    private final ScopedSession scopedSession;

    @Inject
    public SecureDispatchServlet( Dispatch dispatch, SecureSessionValidator sessionValidator, ScopedSession scopedSession) {
        this.dispatch = dispatch;
        this.sessionValidator = sessionValidator;
        this.scopedSession = scopedSession;
    }

	public Result execute( String sessionId, Action<?> action ) throws ActionException, ServiceException {
        try {
            if ( sessionValidator.isValid( sessionId, scopedSession.getSession() ) ) {
                return dispatch.execute( action );
            } else {
                throw new InvalidSessionException();
            }
        } catch ( RuntimeException e ) {
//            log( "Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e );
            throw new ServiceException( e.getMessage() );
        }
    }
    
}
