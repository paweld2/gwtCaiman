package pmsoft.gwt.sample.client.inject;

import pmsoft.gwt.sample.client.layout.AppMainLayoutUi;
import pmsoft.gwt.sample.client.ui.view.LoginViewUI;
import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;
import pmsoft.gwt.sample.shared.ui.view.LoginView;

import com.google.gwt.inject.client.AbstractGinModule;

import eu.caimandesign.gwt.lib.presenter.client.infrastructure.AppRootPanel;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.RootLayout;

public class AppViewModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// FIXME to musi isc gdzie indziej
		bind(RootLayout.class).to(AppRootPanel.class).asEagerSingleton();
		
		bind(LoginView.class).to(LoginViewUI.class);
		
		bind(AppMainLayout.class).to(AppMainLayoutUi.class).asEagerSingleton();
	}

}
