package pmsoft.gwt.sample.inject;

import static org.testng.AssertJUnit.assertTrue;
import net.customware.gwt.dispatch.server.guice.CaimanApplicationGrapher;

import org.testng.annotations.Test;

import pmsoft.gwt.sample.client.inject.AppClientSetupModule;
import pmsoft.gwt.sample.server.AppServletContextListener;

import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.inject.Module;

public class ApplicationInjectorTest {
	// TODO FIXME : how to define and use local development setup 
	private static String ROOT = "/Users/pawel/tmp/";
	
	@Test
	public void testProductionClientInjector(){
		Module clientModule = new GinModuleAdapter(new AppClientSetupModule());
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(clientModule,ROOT + "prod_client.dot");
		assertTrue(grappher.runGraph());
	}
	
	@Test
	public void testProductionServerInjector(){
		Module serverModule =   AppServletContextListener.getFullServerSideModule();
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(serverModule,ROOT + "prod_server.dot");
		assertTrue(grappher.runGraph());		
	}
	
	@Test
	public void testTestInjector(){
		Module testModule = AppModuleFactory.createApplicationModule();
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(testModule,ROOT + "test.dot");
		assertTrue(grappher.runGraph());
	}
}
