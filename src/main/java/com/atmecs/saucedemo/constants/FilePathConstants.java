package com.atmecs.saucedemo.constants;

import java.io.File;

public class FilePathConstants {
	public static final String CURRENT_WORKING_DIRECTORY= System.getProperty("user.dir");
    public static final String RESOURCES_PATH = CURRENT_WORKING_DIRECTORY+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String LOCATORS = RESOURCES_PATH + "locators" + File.separator;
    public static final String SUITE_FILE = RESOURCES_PATH + "suitefile" + File.separator;
    public static final String TEST_DATA = RESOURCES_PATH + "testdata" + File.separator;
    public static final String DRIVERS = RESOURCES_PATH + "drivers" + File.separator;
	
	
	public static final String TESTNG_PATH = SUITE_FILE;
	public static final String LOG4J = TEST_DATA +"log4j.properties";
	public static final String CART_PAGE_LOCATORS = LOCATORS+"CartPage.properties";
	public static final String LOGIN_PAGE_LOCATORS = LOCATORS+"LoginPage.properties";
	public static final String HOME_PAGE_LOCATORS = LOCATORS+"HomePage.properties";
	public static final String EXCEL_DATA = TEST_DATA+"ExcelData.xlsx";
	public static final String CHROME_DRIVER = DRIVERS+"chromedriver.exe";
	
}
