package eu.caimandesign.gwt.lib.presenter.client.infrastructure.view;

import com.google.gwt.event.shared.GwtEvent;

public class ViewEvent extends GwtEvent<ViewHandler> {

	public static final Type<ViewHandler> TYPE = new Type<ViewHandler>();

	@Override
	protected void dispatch(ViewHandler handler) {
		handler.onDisplayEvent(this);
	}

	@Override
	public Type<ViewHandler> getAssociatedType() {
		return TYPE;
	}

}
