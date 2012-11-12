package eu.caimandesign.gwt.lib.presenter.client.place;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanActivity;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.SimplePlaceManager;

public interface PlaceManager extends SimplePlaceManager {

	public boolean fireCurrentPlace();
	
	public void fireActivity(CaimanActivity activity);

}
