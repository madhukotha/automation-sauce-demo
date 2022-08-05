package com.atmecs.saucedemo.pages;

import java.time.Duration;

import org.apache.log4j.Logger;

import com.atmecs.saucedemo.browser.Browser;
import com.atmecs.saucedemo.constants.Constants;
import com.atmecs.saucedemo.driver.DriverManager;
import com.atmecs.saucedemo.page.keys.LoginPageKeys;

public class LoginPage extends Browser {
	static Logger logger = Logger.getLogger(LoginPage.class);
	
	public static void login(String userName, String password) {
		DriverManager.getWebDriver();
		driver.get(Constants.WEBSITE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getPageObjectById("User_Name", "loginpage").sendKeys(userName);
		getPageObjectById("Password", "loginpage").sendKeys(password);
		getPageObjectById("Login_Button", "loginpage").click();
		logger.info("login with " + userName+"");
	}

	public static void login(String browser) {
		DriverManager.getWebDriver(browser);
		driver.get(Constants.WEBSITE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login();
	}

	public boolean loginErrorMessageDisplay() {
		return getPageObject("Login_Error", "loginpage").isDisplayed();
	}
	
	public static String onSuccessfullLogin() {
		
		return getPageObject("SuccessfullLogin", "cartpage").getText();
	}
	
	public static void login() {
		getPageObjectById("User_Name", "loginpage").sendKeys(LoginPageKeys.STANDARD_USER);
		getPageObjectById("Password", "loginpage").sendKeys(LoginPageKeys.STANDARD_USER_PASSWORD);
		getPageObjectById("Login_Button", "loginpage").click();
		logger.info("Re-Login Done with Standard User ");
		
	}
}
