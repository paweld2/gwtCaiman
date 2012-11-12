package eu.caimandesign.gwt.lib.presenter.client.infrastructure.view;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasViewEventHandlers extends HasHandlers {

	HandlerRegistration addViewEventHandler(ViewHandler handler);
	
}
