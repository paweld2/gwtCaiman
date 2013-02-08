package eu.caimandesign.gwt.lib.presenter.client.api.flow;

import com.google.gwt.inject.client.AbstractGinModule;

public abstract class AbstractPresenterFlowModule extends AbstractGinModule {

	protected <P extends PresenterFlow<P, D, A> & ActionFlow<P, D, A>, D extends DisplayFlow<P, D, A>, A extends ActionFlow<P, D, A>> void bindPresenter(
			Class<P> presenter, Class<? extends P> presenterImpl,
			Class<D> display, Class<? extends D> displayImpl) {
		bind(presenter).to(presenterImpl);
		bind(display).to(displayImpl);
	}
}
