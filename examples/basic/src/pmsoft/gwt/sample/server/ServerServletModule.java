package pmsoft.gwt.sample.server;

import net.customware.gwt.dispatch.server.guice.SecureDispatchServlet;

import com.google.inject.servlet.ServletModule;

public class ServerServletModule extends ServletModule{

	@Override
	protected void configureServlets() {
		serve("/integration/dispatch").with(SecureDispatchServlet.class);
//		serve("/*").with(SecureDispatchServlet.class);
	}
	
}
