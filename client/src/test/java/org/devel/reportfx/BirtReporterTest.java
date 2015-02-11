package org.devel.reportfx;

import static org.junit.Assert.assertTrue;

import org.devel.reportfx.tasks.BirtReporter;
import org.junit.Test;

public class BirtReporterTest {

	@Test
	public void test() {
		BirtReporter.export();
		assertTrue(BirtReporter.exists());
	}

}
