package net.customware.gwt.dispatch.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.grapher.GrapherModule;
import com.google.inject.grapher.InjectorGrapher;
import com.google.inject.grapher.graphviz.GraphvizModule;
import com.google.inject.grapher.graphviz.GraphvizRenderer;

public class CaimanApplicationGrapher {
    //FIXME create a util library
	private final Module module;
	private final String filename;

	public CaimanApplicationGrapher(Module module, String filename) {
		super();
		this.module = module;
		this.filename = filename;
	}

	public boolean runGraph() {
		try {
			graphGood(filename, Guice.createInjector(module));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void graphGood(String filename, Injector inj) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(baos);

		Injector injector = Guice.createInjector(new GrapherModule(),
				new GraphvizModule());
		GraphvizRenderer renderer = injector.getInstance(GraphvizRenderer.class);
		renderer.setOut(out).setRankdir("TB");

		injector.getInstance(InjectorGrapher.class).of(inj).graph();

		PrintWriter outFile; 
		if( filename == "-") {
			outFile = new PrintWriter(System.out);
		} else {
			outFile = new PrintWriter(new File(filename), "UTF-8");	
		}
		String s = baos.toString("UTF-8");
		s = fixGrapherBug(s);
		s = hideClassPaths(s);
		outFile.write(s);
		outFile.close();

	}

	private String hideClassPaths(String s) {
		return s.replaceAll("\\w[a-z\\d_\\.]+\\.([A-Z][A-Za-z\\d_]*)", "")
				.replaceAll("value=[\\w-]+", "random");
	}

	private String fixGrapherBug(String s) {
		return s.replaceAll("style=invis", "style=solid");
	}

}
