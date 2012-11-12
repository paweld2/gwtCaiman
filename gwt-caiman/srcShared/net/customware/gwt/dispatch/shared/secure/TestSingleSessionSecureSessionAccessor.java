package net.customware.gwt.dispatch.shared.secure;


public class TestSingleSessionSecureSessionAccessor implements  TestSecureSessionAccessor {

	private String sessionId = null;

	@Override
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public boolean clearSessionId() {
		boolean result = true;
		if (sessionId == null) {
			result = false;
		}
		sessionId = null;
		return result;
	}

}
