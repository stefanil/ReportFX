package org.devel.reportfx;

import java.io.File;
import java.net.URISyntaxException;

public final class Report {

	public static final String EXPORT_URL = "/client/src/main/resources/org/devel/reportfx/export/export.html";
	
	public static void export() {
		
	}
	
	public static boolean exists() {
		try {
			return new File(Report.class.getResource(EXPORT_URL).toURI()).exists();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

}
