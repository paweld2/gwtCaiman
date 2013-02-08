package pmsoft.gwt.sample.client.ui.view;
import pmsoft.gwt.sample.shared.ui.view.LoginView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewCommand;
public class LoginViewUI extends Composite implements LoginView {

	private static LoginViewUIUiBinder uiBinder = GWT
			.create(LoginViewUIUiBinder.class);

	interface LoginViewUIUiBinder extends UiBinder<Widget, LoginViewUI> {
	}

	@UiField
	TextBox login;
	
	@UiField
	PasswordTextBox password;

	@UiField
	Button send;

	@UiField
	Label error;

	public LoginViewUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getUsername() {
		return login.getText();
	}

	@Override
	public String getPassword() {
		return password.getText();
	}
	
	@UiHandler("send")
	public void onSendForm(ClickEvent event){
		loginCommand.fire();
	}

	@Override
	public void setErrorMessage(String error) {
		this.error.setText(error);
	}

	ViewCommand loginCommand = new ViewCommand();

	@Override
	public HasViewEventHandlers onLoginAction() {
		return loginCommand;
	}

}
