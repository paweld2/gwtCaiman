package eu.caimandesign.gwt.lib.presenter.client.activity;

import java.util.LinkedList;
import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;
import eu.caimandesign.gwt.lib.presenter.client.api.flow.AbstractFlowContract;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewHandler;

public class EmptyActivityController implements ActivityController {

	private final LinkedList<HandlerRegistration> registrations;
	
	private final Logger logger = CaimanLogging.getLogger();

	@Inject
	public EmptyActivityController() {
		this.registrations = new LinkedList<HandlerRegistration>();
	}

	@Override
	public void match(HasViewEventHandlers source, ViewHandler handler) {
		HandlerRegistration registration = source.addViewEventHandler(handler);
		registrations.add(registration);
	}

	public void startActivity() {
		logger.fine("Starting Activity");
	}

	public void stopActivity() {
		logger.fine("Stoping Activity");
		for (HandlerRegistration registration : registrations) {
			registration.removeHandler();
		}
	}

	@Override
	public void bind(AbstractFlowContract<?, ?, ?> contract,
			AcceptsOneWidget panel) {
		contract.getPresenterFlow().getDisplay().show(panel, this);
	}

	@Override
	public Class<? extends CaimanPlace> getActivityPlace() {
		return null;
	}


}
