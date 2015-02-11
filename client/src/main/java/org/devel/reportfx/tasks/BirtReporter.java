package org.devel.reportfx.tasks;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.ReportEngine;

public final class BirtReporter {

	private static final String BIRT_RUNTIME_REPORT_ENGINE_URL = "d:/DEVEL/ide/birt-runtime-4_4_1/ReportEngine";
	public static final String IMPORT_URL = "/org/devel/reportfx/in/birt/stadtwerke_zaehlerwechsel_all.rptdesign";
	public static final String EXPORT_URL = "/org/devel/reportfx/out/birt/stadtwerke_zaehlerwechsel_all.html";

	public static void export() {

		// Variables used to control BIRT Engine instance
		EngineConfig conf = null;
		ReportEngine engine = null;
		IReportRunnable design = null;
		IRunAndRenderTask task = null;
		HTMLRenderContext renderContext = null;
		HashMap contextMap = null;
		HTMLRenderOption options = null;

		conf = new EngineConfig();
		conf.setEngineHome(BIRT_RUNTIME_REPORT_ENGINE_URL);

		engine = new ReportEngine(conf);

		try {
			design = engine.openReportDesign(BirtReporter.class.getResource(
					IMPORT_URL).getPath());
		} catch (Exception e) {
			System.err.println("An error occured during the opening of the report file!");
			e.printStackTrace();
		}

		task = engine.createRunAndRenderTask(design);

		options = new HTMLRenderOption();
		options.setOutputFileName(BirtReporter.class.getResource(EXPORT_URL).getPath());
		options.setOutputFormat("html");
		options.setImageDirectory("image");
		task.setRenderOption(options);

		try {
			task.run();
		} catch (Exception e) {
			System.err.println("An error occured while running the report!");
			e.printStackTrace();
		}

		System.out.println("All went well. Closing program!");
		engine.destroy();
	}

	public static boolean exists() {
		try {
			return new File(JasperReporter.class.getResource(EXPORT_URL).toURI())
					.exists();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

}
