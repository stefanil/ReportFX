package org.devel.reportfx.tasks;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

public final class JasperReporter {

	public static final String IMPORT_URL = "/org/devel/reportfx/in/jasper/stadtwerke_zaehlerwechsel_all.jrxml";
	public static final String EXPORT_URL = "/org/devel/reportfx/out/jasper/stadtwerke_zaehlerwechsel_all.html";

	public static void export() {

		Connection connection = createConnection();
		try {
			JasperReport compiledReport = compile();
			JasperPrint filledReport = fill(connection, compiledReport);
			// export
			JasperExportManager.exportReportToHtmlFile(filledReport,
					JasperReporter.class.getResource(EXPORT_URL).getPath());
			System.out.println("Report generated");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public static void print() {

		Connection connection = createConnection();
		try {
			JasperReport compiledReport = compile();
			JasperPrint filledReport = fill(connection, compiledReport);
			// print report
			JasperPrintManager.printReport(filledReport, true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	private static JasperPrint fill(Connection connection,
			JasperReport compiledReport) throws JRException {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JasperPrint filledReport = JasperFillManager.fillReport(compiledReport,
				new HashMap() {
					private static final long serialVersionUID = 6942755415990522205L;
					{
						// put("JASPER_REPORTS_CONTEXT","");
					}
				}, connection);
		return filledReport;
	}

	private static JasperReport compile() throws JRException {
		// compile report temple
		JasperReport compiledReport = JasperCompileManager
				.compileReport(JasperReporter.class.getResourceAsStream(IMPORT_URL));
		return compiledReport;
	}

	private static Connection createConnection() {
		// create jdbc connection
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "stadtwerke";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "stefan";
		// TODO make password empty
		String password = "52RpJdcu";
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + dbName, userName,
					password);
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
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
