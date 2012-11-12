package eu.caimandesign.gwt.lib.caiman.client;

public interface ObservableSource<O> {

	public void addObserver(O o);

	public void deleteObserver(O o);

	public void deleteObservers();

	public int countObservers();
}
