package eu.caimandesign.gwt.lib.presenter.client.infrastructure.view;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class ViewCommand implements HasViewEventHandlers{
	
	private final HandlerManager localReg;
	
	// for testing
	public HandlerManager getLocalReg() {
		return localReg;
	}
	
	public ViewCommand() {
		this.localReg = new HandlerManager(this);
	}

	@Override
	public HandlerRegistration addViewEventHandler(ViewHandler handler) {
		return localReg.addHandler(ViewEvent.TYPE, handler);
	}

	public void fire(){
		this.fireEvent(new ViewEvent());
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		localReg.fireEvent(event);
	}

	
}
