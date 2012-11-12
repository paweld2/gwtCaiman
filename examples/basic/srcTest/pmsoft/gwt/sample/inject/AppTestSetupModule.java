package pmsoft.gwt.sample.inject;

import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.secure.TestSecureSessionAccessor;
import net.customware.gwt.dispatch.shared.secure.TestSingleSessionSecureSessionAccessor;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

public class AppTestSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(TestSecureSessionAccessor.class).to(TestSingleSessionSecureSessionAccessor.class).asEagerSingleton();
	}
	
	@Provides
	public SecureSessionAccessor project(TestSecureSessionAccessor testSession) {
		return testSession;
	}

}
