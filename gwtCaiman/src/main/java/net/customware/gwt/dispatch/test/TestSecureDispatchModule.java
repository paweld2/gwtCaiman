package net.customware.gwt.dispatch.test;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.SecureDispatchServiceAsync;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.DefaultExceptionHandler;
import net.customware.gwt.dispatch.shared.ExceptionHandler;
import net.customware.gwt.dispatch.shared.secure.TestSecureSessionAccessor;
import net.customware.gwt.dispatch.shared.secure.TestSingleSessionSecureSessionAccessor;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class TestSecureDispatchModule extends AbstractGinModule{

	@Override
	protected void configure() {
		bind( ExceptionHandler.class ).to( DefaultExceptionHandler.class );
		bind( DispatchAsync.class).to(TestSecureDispatchAsync.class).in(Singleton.class);
		bind(SecureDispatchServiceAsync.class).to(TestSecureDispatchServiceAsync.class).in(Singleton.class);
		bind(TestSecureSessionAccessor.class).to(TestSingleSessionSecureSessionAccessor.class).asEagerSingleton();
	}

	@Provides
	public SecureSessionAccessor project(TestSecureSessionAccessor testSession) {
		return testSession;
	}
}
