package pmsoft.gwt.sample.inject;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import pmsoft.gwt.sample.client.GwtCaimanSampleApp;
import pmsoft.gwt.sample.shared.ui.view.LoginView;

import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewCommand;
import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;

@Guice(moduleFactory = AppModuleFactory.class)
public class AppSetupTest {

	@Inject
	PlaceManager placeManager;

	@Inject
	GwtCaimanSampleApp app;

	@Inject
	LoginView loginView;

	// @Test
	// public void fireDefaultPlace() {
	// assertTrue(placeManager.fireCurrentPlace());
	// }

	@Test
	public void startApplication() {
		app.startApplication();
		// User not logged, so ping will give invalid session exception
		assertTrue(app.isHttpSessionSet());
		// is View displayed
		ViewCommand command = (ViewCommand) loginView.onLoginAction();
		command.fire();
	}
}
