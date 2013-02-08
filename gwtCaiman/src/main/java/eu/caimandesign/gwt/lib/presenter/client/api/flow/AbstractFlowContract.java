package eu.caimandesign.gwt.lib.presenter.client.api.flow;

import com.google.inject.Provider;

public class AbstractFlowContract<P extends PresenterFlow<P,D,A> & ActionFlow<P,D,A>, D extends DisplayFlow<P,D,A>, A extends ActionFlow<P,D,A>>{

	final Provider<P> presenterProvider;
	final Provider<D> displayProvider;
	public AbstractFlowContract(Provider<P> presenterProvider,
			Provider<D> displayProvider) {
		super();
		this.presenterProvider = presenterProvider;
		this.displayProvider = displayProvider;
	}
	
	public P getPresenterFlow(){
		P p = presenterProvider.get();
		D d = p.getDisplay();
		d.setupActionFlow(p.getActionFlow());
		return p;
	}
	
}
