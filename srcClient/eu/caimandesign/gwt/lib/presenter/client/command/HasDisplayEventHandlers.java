package eu.caimandesign.gwt.lib.presenter.client.command;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDisplayEventHandlers extends HasHandlers {

	HandlerRegistration addDisplayEventHandler(DisplayHandler handler);
	
}
