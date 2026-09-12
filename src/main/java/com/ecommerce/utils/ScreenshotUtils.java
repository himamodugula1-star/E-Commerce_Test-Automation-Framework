package com.ecommerce.utils;

import com.ecommerce.constants.FrameworkConstants;
import com.ecommerce.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

        String filePath = FrameworkConstants.SCREENSHOT_FOLDER
                          + testName + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(source, new File(filePath));

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to save screenshot: " + filePath, e);
        }

        return filePath;
    }
}