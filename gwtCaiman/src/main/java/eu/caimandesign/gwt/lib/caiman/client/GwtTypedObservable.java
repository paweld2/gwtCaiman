package eu.caimandesign.gwt.lib.caiman.client;

import java.util.Vector;

/**
 * Make a class capable to be observed.
 * 
 * Type of events is related to the int type in parameters. Method
 * realizeNotification must be a switch on type to a observer O method call.
 * 
 * @author pawel
 * 
 * @param <O> Interface implemented by Observer
 * @param <S> Interface implemented by Source of events
 */
public abstract class GwtTypedObservable<O, S> implements ObservableSource<O> {

	protected abstract void realizeNotification(S source, O observer, int type);

	private boolean changed = false;
	private Vector<O> obs;

	public GwtTypedObservable() {
		obs = new Vector<O>();
	}

	public synchronized void addObserver(O o) {
		if (o == null)
			throw new NullPointerException();
		if (!obs.contains(o)) {
			obs.addElement(o);
		}
	}

	public synchronized void deleteObserver(O o) {
		obs.removeElement(o);
	}

	@SuppressWarnings("unchecked")
	protected void notifyObservers(S arg, int type) {
		Object[] arrLocal;

		synchronized (this) {

			if (!changed)
				return;
			arrLocal = obs.toArray();
			clearChanged();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--)
			realizeNotification(arg, (O) arrLocal[i], type);
	}

	public synchronized void deleteObservers() {
		obs.removeAllElements();
	}

	protected synchronized void setChanged() {
		changed = true;
	}

	protected synchronized void clearChanged() {
		changed = false;
	}

	public synchronized boolean hasChanged() {
		return changed;
	}

	public synchronized int countObservers() {
		return obs.size();
	}
}
