package pmsoft.gwt.integration.client;

import pmsoft.gwt.sample.client.AppInfrastructureInjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;

public class Integration implements EntryPoint {
	public void onModuleLoad() {
		AppInfrastructureInjector injector = GWT.create(AppInfrastructureInjector.class);
		injector.getApp().startApplication();
	}
}
