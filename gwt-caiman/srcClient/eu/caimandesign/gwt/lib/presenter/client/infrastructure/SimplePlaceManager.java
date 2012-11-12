package eu.caimandesign.gwt.lib.presenter.client.infrastructure;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;

public interface SimplePlaceManager {

	/**
	 * Register places on the manager.
	 * @param place
	 */
	public boolean registerPlace(CaimanPlace place);

	/**
	 * Set the selected place as the default one.
	 * If not called, then the first registered place is the default
	 * @param defaultPlace
	 */
	public void setDefaultPlace(CaimanPlace defaultPlace);
	
}
