package eu.caimandesign.gwt.lib.presenter.client.lazyinit;

/**
 * A object that must be initialized in GWT context.
 * 
 * This is used to avoid use of GWT.create(..) during injector creation. See GwtLayRegistry.
 * @author pawel
 *
 */
public interface GwtLazy {

	public void initialize();
}
