package com.atmecs.saucedemo.runner;

import org.testng.TestNG;

import com.atmecs.saucedemo.constants.FilePathConstants;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner {
	
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> suiteFiles = new ArrayList<String>();
        suiteFiles.add(FilePathConstants.TESTNG_PATH);
        testNG.setTestSuites(suiteFiles);
        testNG.run();
    }
}
