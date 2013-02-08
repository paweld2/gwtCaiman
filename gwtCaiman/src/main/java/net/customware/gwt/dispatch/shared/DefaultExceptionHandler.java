package net.customware.gwt.dispatch.shared;


public class DefaultExceptionHandler implements ExceptionHandler {

	
    public DefaultExceptionHandler() {
    }

    /**
     * Always returns {@link Status#CONTINUE}.
     *
     * @param e The exception.
     * @return The status.
     */
    public Status onFailure( Throwable e ) {
        return Status.CONTINUE;
    }
}
