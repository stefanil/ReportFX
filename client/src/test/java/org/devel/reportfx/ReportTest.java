package org.devel.reportfx;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReportTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		Report.delete();
	}

	@Test
	public void test() {
		Report.export();
		assertTrue(Report.exists());
	}

}
