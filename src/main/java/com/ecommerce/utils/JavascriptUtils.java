package com.ecommerce.utils;

import com.ecommerce.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class JavascriptUtils {

    private JavascriptUtils() {
    }

    private static JavascriptExecutor getJavaScriptExecutor() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    public static void clickUsingJavaScript(By locator) {

        WebElement element = DriverManager.getDriver().findElement(locator);

        getJavaScriptExecutor().executeScript(
                "arguments[0].click();",
                element
        );
    }

    public static void scrollToElement(By locator) {

        WebElement element = DriverManager.getDriver().findElement(locator);

        getJavaScriptExecutor().executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }

    public static void scrollToTop() {

        getJavaScriptExecutor().executeScript(
                "window.scrollTo(0, 0);"
        );
    }

    public static void scrollToBottom() {

        getJavaScriptExecutor().executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
    }
}