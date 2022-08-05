package com.atmecs.saucedemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {

	public static Properties loadProperties(String propertyFilePath) throws IOException {
        File propertyFile = new File(propertyFilePath);
        FileInputStream fileInputStream = new FileInputStream(propertyFile);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }

	public static String getPropertyValue(String key, String propertyFilePath) {
        Properties properties = null;
        try {
            properties = loadProperties(propertyFilePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

