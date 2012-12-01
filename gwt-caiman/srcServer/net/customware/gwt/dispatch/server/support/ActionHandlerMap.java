package net.customware.gwt.dispatch.server.support;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;

public interface ActionHandlerMap<A extends Action<R>, R extends Result> {
    public Class<A> getActionClass();
    
    public Class<? extends ActionHandler<A, R>> getActionHandlerClass();
}
