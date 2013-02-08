package net.customware.gwt.dispatch.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.client.secure.SecureDispatchServiceAsync;
import net.customware.gwt.dispatch.server.secure.ScopedSession;
import net.customware.gwt.dispatch.shared.ar.Action;
import net.customware.gwt.dispatch.shared.ar.Result;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;
import net.customware.gwt.dispatch.shared.secure.TestSecureSessionAccessor;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;

public class TestSecureDispatchServiceAsync implements SecureDispatchServiceAsync {

	private final SecureDispatchService service;
	private final TestSecureSessionAccessor testSessionProvider;
	private final ScopedSession scopedSession;
	private final Logger logger = CaimanLogging.getLogger();

	@Inject
	public TestSecureDispatchServiceAsync(SecureDispatchService service,TestSecureSessionAccessor testSessionProvider,ScopedSession scopedSession) {
		super();
		this.service = service;
		this.testSessionProvider = testSessionProvider;
		this.scopedSession = scopedSession;
	}

	@Override
	public void execute(String sessionId, Action<?> action,
			AsyncCallback<Result> callback) {
		try {
			// Simulate setup of cookie in request
			// First call have sessionId == null
			// This code simulated the setup of a cookie in the returning HTTP request
			// This session is not authenticated, it is just a ServletSession
			if(sessionId == null) {
				String sid = scopedSession.getSession().getSessionId();		
				testSessionProvider.setSessionId(sid);
				sessionId = sid;
			}
			
			
			Result result = service.execute(sessionId, action);
			logger.fine("dispatcher success for action [" + action + "]");
			callback.onSuccess(result);
		} catch ( InvalidSessionException sessionException) {
			logger.log(Level.WARNING, "invalid session exception for action [" + action + "]");
			callback.onFailure(sessionException);
		} catch (Exception e) {
			logger.log(Level.WARNING, "exception on action handler", e);
			callback.onFailure(e);
		}
	}

}
