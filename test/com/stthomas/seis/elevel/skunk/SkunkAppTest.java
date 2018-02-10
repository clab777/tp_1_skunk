package com.stthomas.seis.elevel.skunk;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SkunkAppTest {

	private SkunkApp app;

	@Before
	public void setUp() {
//		app = new SkunkApp();
	}

	@Test
	public void failTest() {

		if (app == null) {
			fail("SkunkApp is null, not instanciated!");
		}
	}
}
