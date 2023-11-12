package com.crm.qa.utils;

import java.io.IOException;
import java.time.Duration;

import com.crm.qa.base.TestBase;

import dev.failsafe.internal.util.Durations;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static  long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT=20;
	
	public void switchToFrame() {
		
		driver.switchTo().frame("mainpanel");
		
	}
	

}
