package eu.caimandesign.gwt.lib.presenter.client.deprecated;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;

import eu.caimandesign.gwt.lib.caiman.client.GwtTypedObservable;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewHandler;

public abstract class BasePresenter<D extends Display> extends
		GwtTypedObservable<PresenterObserver, Presenter<D>> implements
		Presenter<D> {

	protected final D display;
	private static final int PRESENTER_CHANGED = 0;
	private static final int PRESENTER_REVEALED = 1;

	private boolean bound = false;
	private String status = null;
	protected List<HandlerRegistration> registeredHandlers;

	public BasePresenter(D display) {
		this.display = display;
		registeredHandlers = new LinkedList<HandlerRegistration>();
	}
	
	protected void registerDisplayHandler(HasViewEventHandlers command, ViewHandler handler) {
		this.registeredHandlers.add(command.addViewEventHandler(handler));
	}

	@Override
	protected void realizeNotification(Presenter<D> source,
			PresenterObserver observer, int type) {
		switch (type) {
		case PRESENTER_CHANGED:
			observer.changed(source);
			break;
		case PRESENTER_REVEALED:
			observer.revealed(source);
			break;
		default:
			break;
		}
	}
	
	protected final void notifyChange(){
		setChanged();
		notifyObservers(this,PRESENTER_CHANGED);
	}

	@Override
	public String getStatus() {
		return status;
	}
	@Override
	public void setStatus(String status) {
		if( status == null) return;
		if( this.status != null) {
			if( this.status.compareTo(status)==0) {
				return;
			}
		}
		this.status = status;
		this.onStatusChange();
	}
	
	protected void onStatusChange() {
	}
	
	@Override
	public void revealDisplay() {
		onRevealDisplay();
		setChanged();
		notifyObservers(this,PRESENTER_REVEALED);

	}

	protected abstract void onRevealDisplay();

	@Override
	public void bind(PresenterObserver... observers) {
		if (!bound) {
			for (int i = 0; i < observers.length; i++) {
				addObserver(observers[i]);
			}
			onBind();
			bound = true;

		}
	}

	protected abstract void onBind();

	protected abstract void onUnBind();

	@Override
	public void unbind() {
		if (bound) {
			for (HandlerRegistration reg : registeredHandlers) {
				reg.removeHandler();
			}
			registeredHandlers = new LinkedList<HandlerRegistration>();
			onUnBind();
			deleteObservers();
			bound = false;
		}

	}

	@Override
	public D getDisplay() {
		return display;
	}

	@Override
	public boolean isBound() {
		return bound;
	}

}
