package pmsoft.gwt.sample.inject;
import net.customware.gwt.dispatch.test.CaimanApplicationGrapher;

public class SampleModuleGrapher {

	public static void main(String[] args) throws Exception {
		CaimanApplicationGrapher grappher = new CaimanApplicationGrapher(AppModuleFactory.createApplicationModule(),"/tmp/Caiman.dot");
		grappher.runGraph();
	}

}
