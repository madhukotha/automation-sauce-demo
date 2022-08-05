package com.atmecs.saucedemo.browser;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.atmecs.saucedemo.constants.FilePathConstants;
import com.atmecs.saucedemo.utils.PropertyParser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(Browser.class);

	public static void quit() {
		driver.quit();
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static String getCurrentURL() {
		String currentURL = null;

		try {
			currentURL = driver.getCurrentUrl();
		} catch (NullPointerException nullPointerException) {
			System.out.println("Unable Get Current URL " + nullPointerException.getMessage());
		}

		return currentURL;
	}

	public static void getWebDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Initiating chrome browser");
		} catch (Exception e) {
			logger.info("Unable to Load Web Browser");
		}
	}

	public static void configureLog4j() {
		PropertyConfigurator.configure(FilePathConstants.LOG4J);
	}

	//
	public static WebElement getPageObjectById(String idVal, String pageName){

		try {
			WebElement pageId = null;

			if (pageName.equalsIgnoreCase("cartpage")) {
				pageId = driver.findElement(
						By.id(PropertyParser.getPropertyValue(idVal, FilePathConstants.CART_PAGE_LOCATORS)));
			} else if (pageName.equalsIgnoreCase("loginpage")) {
				pageId = driver.findElement(
						By.id(PropertyParser.getPropertyValue(idVal, FilePathConstants.LOGIN_PAGE_LOCATORS)));
			} else if (pageName.equalsIgnoreCase("homepage")) {
				pageId = driver.findElement(
						By.id(PropertyParser.getPropertyValue(idVal, FilePathConstants.HOME_PAGE_LOCATORS)));
			}
			return pageId;

		} catch (Exception e) {

			logger.error("Error in finding element Element " + idVal + "");
			return null;
		}
	}

	public static WebElement getPageObject(String xpath, String pageName) {

		try {
			WebElement pageXpath = null;

			if (pageName.equalsIgnoreCase("cartpage")) {
				pageXpath = driver.findElement(
						By.xpath(PropertyParser.getPropertyValue(xpath, FilePathConstants.CART_PAGE_LOCATORS)));
			} else if (pageName.equalsIgnoreCase("loginpage")) {
				pageXpath = driver.findElement(
						By.xpath(PropertyParser.getPropertyValue(xpath, FilePathConstants.LOGIN_PAGE_LOCATORS)));
			} else if (pageName.equalsIgnoreCase("homepage")) {
				pageXpath = driver.findElement(
						By.xpath(PropertyParser.getPropertyValue(xpath, FilePathConstants.HOME_PAGE_LOCATORS)));
			}
			return pageXpath;

		} catch (Exception e) {

			logger.error("Error in finding element Element " + xpath + "");
			return null;
		}
	}
}
