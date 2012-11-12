package net.customware.gwt.dispatch.shared;

import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AbstractSecureDispatchAsync extends AbstractDispatchAsync {

	protected final SecureSessionAccessor secureSessionAccessor;

	public AbstractSecureDispatchAsync(ExceptionHandler exceptionHandler,
			SecureSessionAccessor secureSessionAccessor) {
		super(exceptionHandler);
		this.secureSessionAccessor = secureSessionAccessor;
	}

	@Override
	public final <A extends Action<R>, R extends Result> void execute(A action,
			AsyncCallback<R> callback) {
        String sessionId = secureSessionAccessor.getSessionId();
        executeSecure(sessionId,action,callback);
	}

	public abstract <A extends Action<R>, R extends Result> void executeSecure(String sessionId, A action,
			AsyncCallback<R> callback);

	
}
