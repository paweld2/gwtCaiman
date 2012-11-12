package net.customware.gwt.dispatch.server.secure;

public interface SecureSession {

	boolean validate(String sessionId);

	public String getSessionId();

	boolean isUserLogin();
	
	void login();

	void logout();

}
