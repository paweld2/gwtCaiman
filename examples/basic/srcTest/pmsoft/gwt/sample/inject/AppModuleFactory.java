package pmsoft.gwt.sample.inject;

import java.util.Iterator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;
import net.customware.gwt.dispatch.server.secure.FakeServerModule;
import net.customware.gwt.dispatch.shared.gin.TestSecureDispatchModule;

import org.testng.IModuleFactory;
import org.testng.ITestContext;
import org.testng.log.TextFormatter;

import pmsoft.gwt.sample.server.AppServletContextListener;
import pmsoft.gwt.sample.shared.inject.AppPresenterModule;
import pmsoft.gwt.sample.shared.inject.AppSetupModule;
import pmsoft.gwt.sample.shared.ui.layout.AppMainLayout;
import pmsoft.gwt.sample.shared.ui.view.LoginView;

import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;
import eu.caimandesign.gwt.lib.presenter.client.gin.CaimanSetupModule;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.RootLayout;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.HasViewEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.infrastructure.view.ViewCommand;

public class AppModuleFactory implements IModuleFactory {

	@Override
	public Module createModule(ITestContext context, Class<?> testClass) {
		Logger logger = CaimanLogging.getLogger();
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new TextFormatter());
		logger.addHandler(handler);
		logger.setLevel(Level.FINEST);
		
		return Modules.combine(
				new GinModuleAdapter(new AppSetupModule()),
				new GinModuleAdapter(CaimanSetupModule.getTestModule()),
				new GinModuleAdapter(new AppPresenterModule()),
				new GinModuleAdapter(new TestSecureDispatchModule()),
				new GinModuleAdapter(new AppTestSetupModule()),
				new ServerDispatchModule(),
				new FakeServerModule(),
				new FakeViewModule(),
				AppServletContextListener.getServerSideModule()
				);
	}
	
	// FIXME to powinno byc generowane przez SPI
	static class FakeViewModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(RootLayout.class).toInstance(new RootLayout(){
				@Override
				public HasWidgets getRootPanel() {
					// TODO Auto-generated method stub
					return new HasWidgets(){

						@Override
						public void add(Widget w) {
							// TODO Auto-generated method stub
							CaimanLogging.getLogger().config("getRootPanel.getRootPanel on add" + w);
						}

						@Override
						public void clear() {
							// TODO Auto-generated method stub
							
						}

						@Override
						public Iterator<Widget> iterator() {
							// TODO Auto-generated method stub
							return null;
						}

						@Override
						public boolean remove(Widget w) {
							// TODO Auto-generated method stub
							return false;
						}
					};
				}
			});
			
			bind(LoginView.class).toInstance(new LoginView(){

				@Override
				public Widget asWidget() {
					CaimanLogging.getLogger().config("loginView as widget");
					return null;
				}

				@Override
				public String getUsername() {
					return null;
				}

				@Override
				public String getPassword() {
					return null;
				}

				@Override
				public void setErrorMessage(String error) {
					
				}

				ViewCommand command = new ViewCommand();
				@Override
				public HasViewEventHandlers onLoginAction() {
					CaimanLogging.getLogger().config("loginView on onLoginAction");
					return command;
				}
				
			});
			
			bind(AppMainLayout.class).toInstance(new AppMainLayout(){

				@Override
				public Widget getContent() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public AcceptsOneWidget getMainPanel() {
					// TODO Auto-generated method stub
					return new AcceptsOneWidget(){
						
						@Override
						public void setWidget(IsWidget w) {
							
						}
						
					};
				}
				
			});

		}
		
	}

}
