package net.customware.gwt.dispatch.client.standard;

import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import net.customware.gwt.dispatch.shared.ar.Result;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dispatch")
public interface StandardDispatchService extends RemoteService {
    Result execute( Action<?> action ) throws ActionException, ServiceException;
}
