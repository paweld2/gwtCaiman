package eu.caimandesign.gwt.lib.presenter.client.api.flow;

public interface PresenterFlow<P extends PresenterFlow<P, D, A> & ActionFlow<P, D, A>, D extends DisplayFlow<P, D, A>, A extends ActionFlow<P, D, A>> extends PresenterSupport<D,A>{

}
