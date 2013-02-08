package pmsoft.gwt.sample.shared.inject;

import pmsoft.gwt.sample.shared.app.AppPlaceRegistry;
import pmsoft.gwt.sample.shared.logic.model.AppModel;
import pmsoft.gwt.sample.shared.logic.model.InMemoryAppModel;

import com.google.gwt.inject.client.AbstractGinModule;

import eu.caimandesign.gwt.lib.presenter.client.infrastructure.PlaceRegistry;

public class AppSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// app level
		bind(PlaceRegistry.class).to(AppPlaceRegistry.class).asEagerSingleton();
		bind(AppModel.class).to(InMemoryAppModel.class).asEagerSingleton();
	}

}
