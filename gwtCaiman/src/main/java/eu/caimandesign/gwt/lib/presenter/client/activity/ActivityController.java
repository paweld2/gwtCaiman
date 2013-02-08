package eu.caimandesign.gwt.lib.presenter.client.activity;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewHandler;


public interface ActivityController extends ActivityContextSupport {

	public void match(HasViewEventHandlers source, ViewHandler handler);

	public void startActivity();
	
	public Class<? extends CaimanPlace> getActivityPlace();

	public void stopActivity();

}
