package com.ecommerce.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static void initializeDriver(String browser) {

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException("Browser cannot be null or empty");
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                DriverManager.setDriver(driver);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }
    }
}