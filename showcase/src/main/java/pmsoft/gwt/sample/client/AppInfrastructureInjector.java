package pmsoft.gwt.sample.client;

import pmsoft.gwt.sample.client.inject.AppClientSetupModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ AppClientSetupModule.class })
public interface AppInfrastructureInjector extends Ginjector {
	public GwtCaimanSampleApp getApp();
}