package eu.caimandesign.gwt.lib.presenter.client.api;

import java.util.Map;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public interface ApplicationPanelManager {

	public AcceptsOneWidget getMainPanel();
	
	public Map<String, AcceptsOneWidget> panelMap();
}
