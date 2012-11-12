package net.customware.gwt.dispatch.shared.test;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

import net.customware.gwt.dispatch.shared.AbstractDispatchAsync;
import net.customware.gwt.dispatch.shared.ExceptionHandler;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;

public class TestStandardDispatchAsync extends AbstractDispatchAsync {

	@Inject
	public TestStandardDispatchAsync(ExceptionHandler exceptionHandler) {
		super(exceptionHandler);
	}

	@Override
	public <A extends Action<R>, R extends Result> void execute(A action,
			AsyncCallback<R> callback) {
		// TODO Auto-generated method stub

	}

}
