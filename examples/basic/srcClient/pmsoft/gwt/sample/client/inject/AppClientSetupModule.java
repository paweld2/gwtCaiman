package pmsoft.gwt.sample.client.inject;

import pmsoft.gwt.sample.client.layout.AppMainLayoutUi;
import pmsoft.gwt.sample.client.ui.view.LoginViewUI;
import pmsoft.gwt.sample.shared.inject.AppPresenterModule;
import pmsoft.gwt.sample.shared.inject.AppSetupModule;
import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;
import pmsoft.gwt.sample.shared.ui.view.LoginView;
import net.customware.gwt.dispatch.client.gin.SecureDispatchModule;
import net.customware.gwt.dispatch.client.secure.CookieSecureSessionAccessor;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import eu.caimandesign.gwt.lib.presenter.client.gin.CaimanSetupModule;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.AppRootPanel;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.RootLayout;

public class AppClientSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		
		install(new AppSetupModule());
		install(new AppPresenterModule());
		install(new CaimanSetupModule());
		install(new SecureDispatchModule());
		
		bind(SecureSessionAccessor.class).to(CookieSecureSessionAccessor.class);
		bind(RootLayout.class).to(AppRootPanel.class).asEagerSingleton();
		bind(LoginView.class).to(LoginViewUI.class);
		bind(AppMainLayout.class).to(AppMainLayoutUi.class).in(Singleton.class);
	}

}
