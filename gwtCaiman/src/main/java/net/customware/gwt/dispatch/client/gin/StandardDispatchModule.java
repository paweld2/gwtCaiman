package net.customware.gwt.dispatch.client.gin;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.dispatch.shared.DefaultExceptionHandler;
import net.customware.gwt.dispatch.shared.ExceptionHandler;

import com.google.gwt.inject.client.AbstractGinModule;

public class StandardDispatchModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(DispatchAsync.class).to(StandardDispatchAsync.class).asEagerSingleton();
		bind(ExceptionHandler.class).to(DefaultExceptionHandler.class);
	}

}
