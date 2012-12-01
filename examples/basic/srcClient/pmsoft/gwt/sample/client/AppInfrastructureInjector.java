package pmsoft.gwt.sample.client;

import net.customware.gwt.dispatch.client.gin.SecureDispatchModule;
import pmsoft.gwt.sample.client.inject.AppClientSetupModule;
import pmsoft.gwt.sample.shared.inject.AppPresenterModule;
import pmsoft.gwt.sample.shared.inject.AppSetupModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import eu.caimandesign.gwt.lib.presenter.client.gin.CaimanSetupModule;

@GinModules({ AppSetupModule.class, AppPresenterModule.class,
		CaimanSetupModule.class, SecureDispatchModule.class,
		AppClientSetupModule.class })
public interface AppInfrastructureInjector extends Ginjector {
	public GwtCaimanSampleApp getApp();
}