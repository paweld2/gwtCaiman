package pmsoft.gwt.sample.shared.inject;

import pmsoft.gwt.sample.shared.app.AppPlaceRegistry;
import pmsoft.gwt.sample.shared.logic.model.AppModel;
import pmsoft.gwt.sample.shared.logic.model.InMemoryAppModel;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityController;
import eu.caimandesign.gwt.lib.presenter.client.activity.EmptyActivityController;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.PlaceRegistry;

public class AppSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// to send to library
		// bind(PlaceManager.class).to(DefaultPlaceManager.class).asEagerSingleton();
		bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();
		// bind(TokenFormatter.class).to(ParameterTokenFormatter.class);
		bind(ActivityController.class).to(EmptyActivityController.class);

		// app level
		bind(PlaceRegistry.class).to(AppPlaceRegistry.class).asEagerSingleton();
		bind(AppModel.class).to(InMemoryAppModel.class).asEagerSingleton();
	}

}
