package net.customware.gwt.dispatch.client.secure;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import net.customware.gwt.dispatch.shared.ar.Result;

@RemoteServiceRelativePath("dispatch")
public interface SecureDispatchService extends RemoteService {
    Result execute( String sessionId, Action<?> action ) throws ActionException, ServiceException;
}
