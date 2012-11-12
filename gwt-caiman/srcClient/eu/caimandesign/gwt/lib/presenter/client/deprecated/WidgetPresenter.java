package eu.caimandesign.gwt.lib.presenter.client.deprecated;


public abstract class WidgetPresenter<D extends WidgetDisplay> extends BasePresenter<D> implements PresenterWidget<D>{
    public WidgetPresenter( D display) {
        super( display );
    }
}
