package com.coherentsolutions.training.auto.API.pashkovskaya.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {
    private static Properties prop;
    private static final String PROPERTIES_PATH = "src/main/resources/properties";

    private PropertiesFileReader() {
        setPropsCache();
    }

    private static void setPropsCache() {
        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseURI() {
        setPropsCache();
        String baseURI = prop.getProperty("baseURI");
        return baseURI;
    }

    public static String getUsername() {
        setPropsCache();
        String username = prop.getProperty("username");
        return username;
    }

    public static String getPassword() {
        setPropsCache();
        String password = prop.getProperty("password");
        return password;
    }
}
