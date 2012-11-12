package eu.caimandesign.gwt.lib.presenter.client.command;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class DisplayCommand implements HasDisplayEventHandlers{
	
	private final HandlerManager localReg;
	
	private final String data;
	
	public DisplayCommand() {
		this(null);
	}

	public DisplayCommand(String data) {
		super();
		this.localReg = new HandlerManager(this);
		this.data = data;
	}

	@Override
	public HandlerRegistration addDisplayEventHandler(DisplayHandler handler) {
		return localReg.addHandler(DisplayEvent.TYPE, handler);
	}

	public void fire(){
		this.fireEvent(new DisplayEvent(data));
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		localReg.fireEvent(event);
	}

	public void fire(String id) {
		this.fireEvent(new DisplayEvent(id));
	}

	public void fire(Integer index) {
		this.fireEvent(new DisplayEvent(index));
	}
	
}
