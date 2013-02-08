package eu.caimandesign.gwt.lib.presenter.client.api;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.infrastructure.PlaceRegistry;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.SimplePlaceManager;

public class AbstractPlaceRegistry implements PlaceRegistry {
	private final CaimanPlace[] places;
	private CaimanPlace defaultPlace;

	@Inject
	public AbstractPlaceRegistry(CaimanPlace... places) {
		this.places = places;
	}
	
	/**
	 * Call this function on constructor to setup the default.
	 * 
	 * @param defaultPlace
	 */
	public void setDefaultPlace(CaimanPlace defaultPlace) {
		this.defaultPlace = defaultPlace;
	}
	
	@Override
	public void loadPlaceOnManager(SimplePlaceManager manager) {
		Preconditions.checkState(places != null && places.length != 0, "No places registered on application. Bind a implemenetation of AbstractPlaceRegistry with places declaration on constructor arguments");
		Preconditions.checkNotNull(defaultPlace,"Default place must be registered. use setDefaultPlace method inside PlaceRegistry constructor");
		for (CaimanPlace place : places) {
			manager.registerPlace(place);
		}
		manager.setDefaultPlace(defaultPlace);
	}
}
