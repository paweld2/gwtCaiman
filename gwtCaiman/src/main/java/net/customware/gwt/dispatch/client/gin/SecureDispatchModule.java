package net.customware.gwt.dispatch.client.gin;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.CookieSecureSessionAccessor;
import net.customware.gwt.dispatch.client.secure.SecureDispatchAsync;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.DefaultExceptionHandler;
import net.customware.gwt.dispatch.shared.ExceptionHandler;

import com.google.gwt.inject.client.AbstractGinModule;

public class SecureDispatchModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(DispatchAsync.class).to(SecureDispatchAsync.class).asEagerSingleton();
		bind(ExceptionHandler.class).to(DefaultExceptionHandler.class);
        bind(SecureSessionAccessor.class).to(CookieSecureSessionAccessor.class);
	}

}
