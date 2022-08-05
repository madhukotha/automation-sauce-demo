package com.atmecs.saucedemo.verification;

import org.testng.Assert;

public class Verify {
 
	public static boolean assertString(String actualText, String expectedText) {
      
        boolean status = false;
        try {
            Assert.assertEquals(actualText, expectedText);
            status = true;
            System.out.println("Actual Result"+actualText+"Expected Result "+expectedText+" are same");
            
        } catch (Exception e) {
        	System.out.println("Actual Result"+actualText+"Expected Result "+expectedText+" are not same");
        }
        return status;
    }

    public static boolean assertBoolean(boolean actual) {
       
        boolean status = false;
        try {
            Assert.assertTrue(actual);
            status = true;
            System.out.println("Aseertion is passed");
        } catch (Exception e) {
        	System.out.println("Aseertion is failed");
        }
        return status;
    }
    
    public static boolean assertFalse(boolean actual) {
        
        boolean status = true;
        try {
            Assert.assertFalse(actual);
            status = false;
            System.out.println("Aseertion is passed");
        } catch (Exception e) {
        	System.out.println("Aseertion is failed");
        }
        return status;
    }
}
