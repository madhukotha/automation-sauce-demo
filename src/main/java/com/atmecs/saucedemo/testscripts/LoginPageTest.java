package com.atmecs.saucedemo.testscripts;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.saucedemo.excel.ExcelReader;
import com.atmecs.saucedemo.page.keys.LoginPageKeys;
import com.atmecs.saucedemo.pages.LoginPage;

public class LoginPageTest extends LoginPage {
	static Logger logger = Logger.getLogger(LoginPageTest.class);

	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelReader.class)
	public void nagitiveLoginData(String userName, String password) {
		configureLog4j();
		login(userName, password);

		assertTrue(loginErrorMessageDisplay());

		if (!userName.equalsIgnoreCase(LoginPageKeys.STANDARD_USER)
				&& !password.equalsIgnoreCase(LoginPageKeys.STANDARD_USER_PASSWORD)) {
			logger.info("worng username and password unable to login");
		}

		else if (userName == "") {
			logger.info("username cannot be blank");
		} else if (password == "") {
			logger.info("password cannot be blank");
		}

		else if (!userName.equalsIgnoreCase(LoginPageKeys.STANDARD_USER)) {
			logger.info("wrong username unable to login");
		} else if (!password.equalsIgnoreCase(LoginPageKeys.STANDARD_USER_PASSWORD)) {
			logger.info("worng password unable to login");
		}
		quit();
	}

}
