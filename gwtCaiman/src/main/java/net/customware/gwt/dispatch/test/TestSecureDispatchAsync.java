package net.customware.gwt.dispatch.test;

import net.customware.gwt.dispatch.client.secure.SecureDispatchServiceAsync;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.AbstractSecureDispatchAsync;
import net.customware.gwt.dispatch.shared.ExceptionHandler;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class TestSecureDispatchAsync extends AbstractSecureDispatchAsync {

	private final SecureDispatchServiceAsync service;
	
	@Inject
	public TestSecureDispatchAsync(ExceptionHandler exceptionHandler,
			SecureSessionAccessor secureSessionAccessor,SecureDispatchServiceAsync service) {
		super(exceptionHandler, secureSessionAccessor);
		this.service = service;
	}

	@Override
	public <A extends Action<R>, R extends Result> void executeSecure(
			String sessionId, final A action, final AsyncCallback<R> callback) {
		service.execute(sessionId, action, new AsyncCallback<Result>() {
			public void onFailure(Throwable caught) {
				TestSecureDispatchAsync.this.onFailure(action, caught, callback);
			}

			@SuppressWarnings({ "unchecked" })
			public void onSuccess(Result result) {
				TestSecureDispatchAsync.this
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
