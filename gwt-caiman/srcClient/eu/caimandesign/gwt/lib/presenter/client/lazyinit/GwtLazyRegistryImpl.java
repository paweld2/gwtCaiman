package eu.caimandesign.gwt.lib.presenter.client.lazyinit;

import java.util.LinkedList;

public class GwtLazyRegistryImpl implements GwtLazyRegistry {

	LinkedList<GwtLazy> registry = new LinkedList<GwtLazy>();

	@Override
	public void addLazy(GwtLazy init) {
		if( registry != null) {
			registry.add(init);
		}
	}

	@Override
	public void runInitialization() {
		if( registry != null) {
			for (GwtLazy init : registry) {
				init.initialize();
			}
			registry = null;
		}
	}

}
