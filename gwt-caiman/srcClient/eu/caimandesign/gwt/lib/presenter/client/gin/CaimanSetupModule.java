package eu.caimandesign.gwt.lib.presenter.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;

import eu.caimandesign.gwt.lib.presenter.client.place.DefaultPlaceManager;
import eu.caimandesign.gwt.lib.presenter.client.place.HistoryApi;
import eu.caimandesign.gwt.lib.presenter.client.place.HistoryClientApi;
import eu.caimandesign.gwt.lib.presenter.client.place.ParameterTokenFormatter;
import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;
import eu.caimandesign.gwt.lib.presenter.client.place.TokenFormatter;
import eu.caimandesign.gwt.lib.presenter.shared.HistorySharedApi;

public class CaimanSetupModule extends AbstractGinModule {

	private final Class<? extends PlaceManager> placeManagerClass;

	private final Class<? extends TokenFormatter> tokenFormatterClass;
	
	private final Class<? extends HistoryApi> historyApiClass;

	public CaimanSetupModule() {
		this(DefaultPlaceManager.class, ParameterTokenFormatter.class,HistoryClientApi.class);
	}

	public static CaimanSetupModule getTestModule() {
		return new CaimanSetupModule(DefaultPlaceManager.class,ParameterTokenFormatter.class, HistorySharedApi.class);
	}

	public CaimanSetupModule(Class<? extends PlaceManager> placeManagerClass,
			Class<? extends TokenFormatter> tokenFormatterClass,
			Class<? extends HistoryApi> historyApiClass) {
		this.placeManagerClass = placeManagerClass;
		this.tokenFormatterClass = tokenFormatterClass;
		this.historyApiClass = historyApiClass;
	}

	@Override
	protected void configure() {
		bind(TokenFormatter.class).to(tokenFormatterClass);
		bind(PlaceManager.class).to(placeManagerClass).asEagerSingleton();
		bind(HistoryApi.class).to(historyApiClass).asEagerSingleton();
		bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();

	}

	@Override
	public boolean equals(Object object) {
		return object instanceof CaimanSetupModule;
	}

	public int hashCode() {
		return 19;
	}
}
