package pmsoft.gwt.sample.shared.ui.view;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.ViewFlow;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;

public interface LoginView extends ViewFlow {
	public String getUsername();
	public String getPassword();
	public void setErrorMessage(String error);
	public HasViewEventHandlers onLoginAction();
}
