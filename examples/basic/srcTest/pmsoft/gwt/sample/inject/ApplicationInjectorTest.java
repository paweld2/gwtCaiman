package pmsoft.gwt.sample.inject;

import static org.testng.AssertJUnit.assertTrue;
import net.customware.gwt.dispatch.server.guice.CaimanApplicationGrapher;

import org.testng.annotations.Test;

import pmsoft.gwt.sample.client.inject.AppClientSetupModule;
import pmsoft.gwt.sample.server.AppServletContextListener;

import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.inject.Module;

public class ApplicationInjectorTest {
	private static String CAIMAN_GRAPH_PATH_PROPERTY = "caiman.graph.path";
	
	
	private String getFullFilename(String filename) {
		String dirPath = System.getProperty(CAIMAN_GRAPH_PATH_PROPERTY);
		if( dirPath == null) {
			return "-";
		}
		return dirPath + filename;
	}
	
	@Test
	public void testProductionClientInjector(){
		Module clientModule = new GinModuleAdapter(new AppClientSetupModule());
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(clientModule,getFullFilename("prod_client.dot"));
		assertTrue(grappher.runGraph());
	}
	
	@Test
	public void testProductionServerInjector(){
		Module serverModule =   AppServletContextListener.getFullServerSideModule();
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(serverModule,getFullFilename("prod_server.dot"));
		assertTrue(grappher.runGraph());		
	}
	
	@Test
	public void testTestInjector(){
		Module testModule = AppModuleFactory.createApplicationModule();
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(testModule,getFullFilename("test.dot"));
		assertTrue(grappher.runGraph());
	}
}
