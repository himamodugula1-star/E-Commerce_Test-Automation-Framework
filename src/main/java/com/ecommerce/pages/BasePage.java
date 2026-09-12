package com.ecommerce.pages;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.utils.JavascriptUtils;
import com.ecommerce.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected void click(By locator) {

        closePopupIfPresent();

        WebElement element =
                WaitUtils.waitForClickable(locator);

        try {

            element.click();

        } catch (ElementClickInterceptedException e) {

            closePopupIfPresent();

            JavascriptUtils.scrollToElement(locator);
            JavascriptUtils.clickUsingJavaScript(locator);
        }
    }

    protected void type(By locator, String text) {
        closePopupIfPresent();
        WaitUtils.waitForVisibility(locator)
                .sendKeys(text);
    }

    protected void clear(By locator) {
        WaitUtils.waitForVisibility(locator)
                .clear();
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisibility(locator)
                .getText();
    }

    protected void closePopupIfPresent() {

        By closeButton =
                By.xpath("//*[normalize-space()='Close']");

        try {

            for (WebElement element :
                    getDriver().findElements(closeButton)) {

                if (element.isDisplayed() && element.isEnabled()) {

                    element.click();
                    break;
                }
            }

        } catch (Exception e) {

            // Ignore popup if it is not present
        }
    }
}