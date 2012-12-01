package pmsoft.gwt.sample.server;

import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;
import pmsoft.gwt.sample.server.handlers.AppActionHandlerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.util.Modules;

public class AppServletContextListener extends GuiceServletContextListener {

	public static Module getServerSideModule(){
		return Modules.combine(new ServerDispatchModule(), new AppActionHandlerModule());
	}
	
	@Override
	protected Injector getInjector() {
		Module serverSideModule = getServerSideModule();
		Module all = Modules.combine(serverSideModule, new ServerSessionModule(), new ServerServletModule());
		return Guice.createInjector(all);
	}

}
