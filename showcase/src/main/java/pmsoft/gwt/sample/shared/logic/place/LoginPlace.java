package pmsoft.gwt.sample.shared.logic.place;

import pmsoft.gwt.sample.shared.flow.LoginFlow;
import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityContextSupport;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.Layout;

public class LoginPlace extends CaimanPlace {

	private final LoginFlow login;
	
	// Layout access is lazy to avoid GWT.create() on ui binder
	private final Provider<AppMainLayout> mainLayout;

	@Inject
	public LoginPlace(LoginFlow login,Provider<AppMainLayout> mainLayout) {
		super();
		this.login = login;
		this.mainLayout = mainLayout;
	}
	
	@Override
	public Layout setupLayout(ActivityContextSupport context) {
		AppMainLayout appMainLayout = mainLayout.get();
		context.bind(login, appMainLayout.getMainPanel());
		return appMainLayout;
	}

}
