package eu.caimandesign.gwt.lib.caiman.test;


import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

public class TestObservableApi {
	@Test
	public void testObservation() {
		Observable observable = new Observable();

		ObserverContract observer = new ObserverContract() {
			int eventCounter = 0;

			@Override
			public void eventTwo() {
				eventCounter++;
			}

			@Override
			public void eventOne() {
				eventCounter++;
			}

			@Override
			public int eventCount() {
				return eventCounter;
			}
		};
		observable.addObserver(observer);
		assertEquals(0, observer.eventCount());
		observable.runEvents();
		assertEquals(2, observer.eventCount());
		
	}
}
