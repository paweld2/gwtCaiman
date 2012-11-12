package net.customware.gwt.dispatch.client.secure;

import com.google.gwt.user.client.Cookies;
import com.google.inject.Inject;

public class CookieSecureSessionAccessor implements SecureSessionAccessor {

    private String cookieName;

    @Inject
    public CookieSecureSessionAccessor() {
    	//FIXME make something easy to use
    	this.cookieName = "defaultCookieName";
    }
    
    public CookieSecureSessionAccessor( String cookieName ) {
        this.cookieName = cookieName;
    }

    public boolean clearSessionId() {
        if ( Cookies.getCookie( cookieName ) != null ) {
            Cookies.removeCookie( cookieName );
        }
        return false;
    }

    public String getSessionId() {
        return Cookies.getCookie( cookieName );
    }

}
