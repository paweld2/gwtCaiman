package eu.caimandesign.gwt.lib.presenter.client.infrastructure.view;

import com.google.gwt.event.shared.EventHandler;

public interface ViewHandler extends EventHandler {

	public void onDisplayEvent(ViewEvent event);
	
}
