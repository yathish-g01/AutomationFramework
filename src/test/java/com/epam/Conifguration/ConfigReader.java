package com.epam.Conifguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("BASEURL");
    }

    public String getUsername() {
        return properties.getProperty("USERNAME");
    }

    public String getPassword() {
        return properties.getProperty("PASSWORD");
    }

    public String getCustomerId() {
        return properties.getProperty("CUSTOMERID");
    }
}