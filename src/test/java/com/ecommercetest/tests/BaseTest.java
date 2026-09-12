package com.ecommercetest.tests;

import com.ecommerce.config.ConfigReader;
import com.ecommerce.driver.DriverFactory;
import com.ecommerce.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    protected ConfigReader configReader;

    @BeforeMethod
    public void setUp() {

        logger.info("Starting test setup");

        configReader = new ConfigReader();

        String browser =
                configReader.getProperty("browser");

        String url =
                configReader.getProperty("url");

        System.out.println("BROWSER = [" + browser + "]");
        System.out.println("URL = [" + url + "]");

        logger.info("Browser configured as: {}", browser);
        logger.info("Application URL: {}", url);

        DriverFactory.initializeDriver(browser);

        logger.info("WebDriver initialized successfully");

        DriverManager.getDriver()
                .manage()
                .window()
                .maximize();

        logger.info("Browser window maximized");

        DriverManager.getDriver().get(url);

        logger.info("Application opened successfully");
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Starting test teardown");

        DriverManager.quitDriver();

        logger.info("WebDriver closed successfully");
    }
}