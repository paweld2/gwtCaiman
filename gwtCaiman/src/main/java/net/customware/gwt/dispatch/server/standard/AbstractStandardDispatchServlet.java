package net.customware.gwt.dispatch.server.standard;

import net.customware.gwt.dispatch.client.standard.StandardDispatchService;
import net.customware.gwt.dispatch.server.Dispatch;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import net.customware.gwt.dispatch.shared.ar.Result;

public abstract class AbstractStandardDispatchServlet extends RemoteServiceServlet implements StandardDispatchService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8453154751041227592L;

	public Result execute( Action<?> action ) throws ActionException, ServiceException {
        try {
            return getDispatch().execute( action );
        } catch ( RuntimeException e ) {
            log( "Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e );
            throw new ServiceException( e );
        }
    }

    /**
     * 
     * @return The Dispatch instance.
     */
    protected abstract Dispatch getDispatch();

}
