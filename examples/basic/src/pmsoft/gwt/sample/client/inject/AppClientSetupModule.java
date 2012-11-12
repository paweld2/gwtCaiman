package pmsoft.gwt.sample.client.inject;

import net.customware.gwt.dispatch.client.secure.CookieSecureSessionAccessor;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;

import com.google.gwt.inject.client.AbstractGinModule;

public class AppClientSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(SecureSessionAccessor.class).to(CookieSecureSessionAccessor.class);
	}

}
