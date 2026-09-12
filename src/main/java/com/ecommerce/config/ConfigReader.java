package com.ecommerce.config;

import com.ecommerce.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();

        try (FileInputStream fis =
                     new FileInputStream(FrameworkConstants.CONFIGREADER_PATH)) {

            properties.load(fis);

            System.out.println("CONFIG FILE LOADED");
            System.out.println(
                    "BROWSER VALUE = [" + properties.getProperty("browser") + "]"
            );
            System.out.println(
                    "URL VALUE = [" + properties.getProperty("url") + "]"
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties", e
            );
        }
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
