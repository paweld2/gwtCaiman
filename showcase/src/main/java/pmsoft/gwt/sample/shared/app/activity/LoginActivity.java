package pmsoft.gwt.sample.shared.app.activity;

import pmsoft.gwt.sample.shared.logic.place.LoginPlace;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanActivity;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;

public class LoginActivity extends CaimanActivity {

	@Override
	public Class<? extends CaimanPlace> getCurrentPlace() {
		return LoginPlace.class;
	}

}
