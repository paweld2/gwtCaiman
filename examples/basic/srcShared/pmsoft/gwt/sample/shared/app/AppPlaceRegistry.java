package pmsoft.gwt.sample.shared.app;

import com.google.inject.Inject;

import pmsoft.gwt.sample.shared.logic.place.LoginPlace;
import eu.caimandesign.gwt.lib.presenter.client.api.AbstractPlaceRegistry;

public class AppPlaceRegistry extends AbstractPlaceRegistry {

	@Inject
	public AppPlaceRegistry(LoginPlace login) {
		super(login);
		setDefaultPlace(login);
	}

}
