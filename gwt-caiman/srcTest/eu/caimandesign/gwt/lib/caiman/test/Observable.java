package eu.caimandesign.gwt.lib.caiman.test;

import eu.caimandesign.gwt.lib.caiman.client.GwtTypedObservable;

class Observable extends
		GwtTypedObservable<ObserverContract, SourceContractTest> implements
		SourceContractTest {

	private static final int NOTIFICATION_TYPE_ONE = 0;
	private static final int NOTIFICATION_TYPE_TWO = 1;

	@Override
	protected void realizeNotification(SourceContractTest source,
			ObserverContract observer, int type) {
		switch (type) {
		case NOTIFICATION_TYPE_ONE:
			observer.eventOne();
			break;
		case NOTIFICATION_TYPE_TWO:
			observer.eventTwo();
			break;
		default:
			break;
		}
	}

	protected void notifyOne() {
		setChanged();
		notifyObservers(this, NOTIFICATION_TYPE_ONE);
	}

	protected void notifyTwo() {
		setChanged();
		notifyObservers(this, NOTIFICATION_TYPE_TWO);
	}

	public void runEvents() {
		notifyOne();
		notifyTwo();
	}

}
