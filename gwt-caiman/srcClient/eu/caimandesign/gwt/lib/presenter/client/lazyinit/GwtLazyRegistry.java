package eu.caimandesign.gwt.lib.presenter.client.lazyinit;

public interface GwtLazyRegistry {

	public void addLazy(GwtLazy init);
	
	public void runInitialization();
}
