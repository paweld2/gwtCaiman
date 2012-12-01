package pmsoft.gwt.sample.shared.logic.place;

import pmsoft.gwt.sample.shared.flow.LoginFlow;
import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;

import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.activity.ActivityContextSupport;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.Layout;

public class LoginPlace extends CaimanPlace {

	private final LoginFlow login;
	
	private final AppMainLayout mainLayout;

	@Inject
	public LoginPlace(LoginFlow login,AppMainLayout mainLayout) {
		super();
		this.login = login;
		this.mainLayout = mainLayout;
	}
	
	@Override
	public Layout setupLayout(ActivityContextSupport context) {
		context.bind(login, mainLayout.getMainPanel());
		return mainLayout;
	}

}
