package org.devel.reportfx;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReportUtilityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertFalse(checkReportExists());
		Report.export(); 
		assertTrue(checkReportExists());
	}

	private boolean checkReportExists() {
		
		
		
		return false;
	}

}
