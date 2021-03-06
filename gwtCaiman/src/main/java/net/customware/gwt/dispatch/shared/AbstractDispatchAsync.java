package net.customware.gwt.dispatch.shared;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * An abstract base class that provides methods that can be called to handle success or failure
 * results from the remote service. These should be called by the implementation of
 * {@link #execute(net.customware.gwt.dispatch.shared.ar.Action, com.google.gwt.user.client.rpc.AsyncCallback)}.
 * 
 * @author David Peterson
 */
public abstract class AbstractDispatchAsync implements DispatchAsync {

    private final ExceptionHandler exceptionHandler;

    public AbstractDispatchAsync( ExceptionHandler exceptionHandler ) {
        this.exceptionHandler = exceptionHandler;
    }

    protected <A extends Action<R>, R extends Result> void onFailure( A action, Throwable caught, final AsyncCallback<R> callback ) {
        if ( exceptionHandler != null && exceptionHandler.onFailure( caught ) == ExceptionHandler.Status.STOP ) {
            return;
        }

        callback.onFailure( caught );
    }

    protected <A extends Action<R>, R extends Result> void onSuccess( A action, R result, final AsyncCallback<R> callback ) {
        callback.onSuccess( result );
    }

}
