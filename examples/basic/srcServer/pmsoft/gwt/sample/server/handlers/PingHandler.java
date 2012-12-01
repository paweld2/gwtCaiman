package pmsoft.gwt.sample.server.handlers;

import net.customware.gwt.dispatch.server.AbstractActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ar.ActionException;
import pmsoft.gwt.sample.shared.ar.PingAction;
import pmsoft.gwt.sample.shared.ar.PingResult;


public class PingHandler extends AbstractActionHandler<PingAction, PingResult> {

	public PingHandler() {
		super(PingAction.class);
	}

	@Override
	public PingResult execute(PingAction action, ExecutionContext context)
			throws ActionException {
		// TODO Auto-generated method stub
		return new PingResult();
	}

	@Override
	public void rollback(PingAction action, PingResult result,
			ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub
		
	}


}
