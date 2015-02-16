package org.devel.reportfx.tasks;

import static org.junit.Assert.*;

import org.devel.reportfx.tasks.JasperReporter;
import org.junit.Test;

public class JasperReporterTest {

	@Test
	public void test() {
		JasperReporter.export();
		assertTrue(JasperReporter.exists());
	}

}
