package net.customware.gwt.dispatch.client.secure;

import net.customware.gwt.dispatch.shared.AbstractSecureDispatchAsync;
import net.customware.gwt.dispatch.shared.ExceptionHandler;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class SecureDispatchAsync extends AbstractSecureDispatchAsync {

    private static final SecureDispatchServiceAsync realService = GWT.create( SecureDispatchService.class );

    private final SecureSessionAccessor secureSessionAccessor;

    @Inject
    public SecureDispatchAsync( ExceptionHandler exceptionHandler, SecureSessionAccessor secureSessionAccessor ) {
        super( exceptionHandler ,secureSessionAccessor);
        this.secureSessionAccessor = secureSessionAccessor;
    }

    public <A extends Action<R>, R extends Result> void executeSecure(String sessionId, final A action, final AsyncCallback<R> callback ) {
		realService.execute(sessionId, action, new AsyncCallback<Result>() {
			public void onFailure(Throwable caught) {
				SecureDispatchAsync.this.onFailure(action, caught, callback);
			}

			@SuppressWarnings({ "unchecked" })
			public void onSuccess(Result result) {
				SecureDispatchAsync.this
						.onSuccess(action, (R) result, callback);
			}
		});
    	
    }

    protected <A extends Action<R>, R extends Result> void onFailure( A action, Throwable caught, final AsyncCallback<R> callback ) {
        if ( caught instanceof InvalidSessionException ) {
            secureSessionAccessor.clearSessionId();
        }
        super.onFailure( action, caught, callback );
    }
}
