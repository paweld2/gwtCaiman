package eu.caimandesign.gwt.lib.presenter.client.infrastructure;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class AppRootPanel implements RootLayout {

	@Override
	public Panel getRootPanel() {
		return RootLayoutPanel.get();
	}

}
