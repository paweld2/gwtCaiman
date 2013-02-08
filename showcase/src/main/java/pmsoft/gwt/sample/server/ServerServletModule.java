package pmsoft.gwt.sample.server;

import net.customware.gwt.dispatch.server.secure.SecureDispatchServlet;

import com.google.inject.servlet.ServletModule;

public class ServerServletModule extends ServletModule{

	@Override
	protected void configureServlets() {
		//FIXME provide a predefined module in the library 
		serve("/integration/dispatch").with(SecureDispatchServlet.class);
	}
	
}
