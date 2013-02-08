package net.customware.gwt.dispatch.client.secure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;

public interface SecureDispatchServiceAsync {
    void execute( String sessionId, Action<?> action, AsyncCallback<Result> callback );
}
