package com.atmecs.saucedemo.driver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.atmecs.saucedemo.browser.Browser;
import com.atmecs.saucedemo.constants.FilePathConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends Browser {
	static Logger logger = Logger.getLogger(DriverManager.class);

	public static void getWebDriver(String browserName) {
		configureLog4j();
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", FilePathConstants.CHROME_DRIVER);
				driver = new ChromeDriver();
				logger.info("Initiating chrome browser");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Initiating firefox browser");
			}
		} catch (Exception e) {
			logger.info("Unable to Load Web Browser");
		}
	}

	public static void getWebDriver() {
		configureLog4j();
		try {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", FilePathConstants.CHROME_DRIVER);
			driver = new ChromeDriver();
			logger.info("Initiating chrome browser");
		} catch (Exception e) {
			logger.info("Unable to Load Web Browser");
		}
	}
	
	public static void configureLog4j() {
		PropertyConfigurator.configure(FilePathConstants.LOG4J);
	}
}
