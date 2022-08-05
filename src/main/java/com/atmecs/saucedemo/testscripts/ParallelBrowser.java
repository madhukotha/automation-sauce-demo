package com.atmecs.saucedemo.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.saucedemo.driver.DriverManager;
import com.atmecs.saucedemo.page.keys.HomePageKeys;
import com.atmecs.saucedemo.pages.LoginPage;
import com.atmecs.saucedemo.verification.Verify;

public class ParallelBrowser extends LoginPage {
	static Logger logger = Logger.getLogger(DriverManager.class);
	
	@Test
	@Parameters({"browser"})
	public void parallelTest(String browser) {
		login(browser);
		Verify.assertString(HomePageKeys.ACTUAL_WHEN_LOGIN, onSuccessfullLogin());
		logger.info("Login with parallel "+browser+" is successful");
		quit();
	}
}
	/*
	@Test
	public void firefoxTest() {
		login(BrowserType.FIREFOX, LoginPageKeys.PERFORMANCE_GLITCH_USER, 
				LoginPageKeys.PERFORMANCE_GLITCH_USER_PASSWORD);
		Verify.assertString(HomePageKeys.ACTUAL_WHEN_LOGIN, onSuccessfullLogin());
		quit();
	}*/

