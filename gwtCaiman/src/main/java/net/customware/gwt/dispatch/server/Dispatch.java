package net.customware.gwt.dispatch.server;

import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import net.customware.gwt.dispatch.shared.ar.Result;

public interface Dispatch {

    /**
     * Executes the specified action and returns the appropriate result.
     * 
     * @param <T>
     *            The {@link Result} type.
     * @param action
     *            The {@link Action}.
     * @return The action's result.
     * @throws ActionException
     *             if the action execution failed.
     */
    <A extends Action<R>, R extends Result> R execute( A action ) throws ActionException;
}
