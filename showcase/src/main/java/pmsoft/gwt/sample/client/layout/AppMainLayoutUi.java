package pmsoft.gwt.sample.client.layout;

import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppMainLayoutUi extends Composite implements AppMainLayout {

	private static AppMainLayoutUiBinder uiBinder = GWT
			.create(AppMainLayoutUiBinder.class);

	interface AppMainLayoutUiBinder extends UiBinder<Widget, AppMainLayoutUi> {
	}

	@UiField
	SimplePanel mainPanel;

	@Inject
	public AppMainLayoutUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget getContent() {
		return this;
	}

	@Override
	public AcceptsOneWidget getMainPanel() {
		return mainPanel;
	}

}
