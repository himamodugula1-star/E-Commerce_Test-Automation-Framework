package com.ecommerce.listeners;

import com.ecommerce.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(
                "Test Started: {}",
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(
                "Test Passed: {}",
                result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
                "Test Failed: {}",
                result.getName(),
                result.getThrowable()
        );

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        result.getName()
                );

        try {

            byte[] screenshot =
                    Files.readAllBytes(
                            Path.of(screenshotPath)
                    );

            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png"
            );

        } catch (IOException e) {

            logger.error(
                    "Unable to attach screenshot to Allure",
                    e
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn(
                "Test Skipped: {}",
                result.getName()
        );
    }
}