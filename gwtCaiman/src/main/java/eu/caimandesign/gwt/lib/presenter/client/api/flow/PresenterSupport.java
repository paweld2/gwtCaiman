package eu.caimandesign.gwt.lib.presenter.client.api.flow;

public interface PresenterSupport<D extends DisplaySupport<A>,A> {
	public A getActionFlow();
	public D getDisplay();
//	public void setDisplay(D display);
}
