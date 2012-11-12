package net.customware.gwt.dispatch.shared.gin;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.SecureDispatchServiceAsync;
import net.customware.gwt.dispatch.shared.DefaultExceptionHandler;
import net.customware.gwt.dispatch.shared.ExceptionHandler;
import net.customware.gwt.dispatch.shared.test.TestSecureDispatchAsync;
import net.customware.gwt.dispatch.shared.test.TestSecureDispatchServiceAsync;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class TestSecureDispatchModule extends AbstractGinModule{

	@Override
	protected void configure() {
		bind( ExceptionHandler.class ).to( DefaultExceptionHandler.class );
		bind( DispatchAsync.class).to(TestSecureDispatchAsync.class).in(Singleton.class);
		bind(SecureDispatchServiceAsync.class).to(TestSecureDispatchServiceAsync.class).in(Singleton.class); 
	}

//	public TestSecureDispatchModule() {
//		super(DefaultExceptionHandler.class);
//	}

//	@Provides
//	@Singleton
//	protected DispatchAsync provideDispatchAsync(
//			ExceptionHandler exceptionHandler,
//			SecureSessionAccessor secureSessionAccessor,SecureDispatchServiceAsync service) {
//		return new TestSecureDispatchAsync(exceptionHandler, secureSessionAccessor, service);
//	}
//
//	@Provides
//	@Singleton
//	protected SecureDispatchServiceAsync provideSecureDispatchServiceAsync(SecureDispatchService service){
//		return new TestSecureDispatchServiceAsync(service);
//	}

}
