package com.atmecs.saucedemo.base;

import org.testng.annotations.*;

import com.atmecs.saucedemo.browser.Browser;

public class TestBase {
    public Browser browser = null;

    
    @BeforeClass
    public void beforeClass() {
        browser = new Browser();
        
    }

    @AfterClass
    public void afterClass() {
        Browser.quit();
    }
    
}
