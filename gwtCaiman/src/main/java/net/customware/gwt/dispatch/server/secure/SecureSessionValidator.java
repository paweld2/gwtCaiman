package net.customware.gwt.dispatch.server.secure;

public interface SecureSessionValidator {
	
	boolean isValid(String sessionId, SecureSession session);
	
}
