package com.ecommerce.pages;

import com.ecommerce.utils.WaitUtils;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By productsLink =
            By.xpath("//a[@href='/products']");

    private final By cartLink =
            By.xpath("//a[@href='/view_cart']");

    private final By signupLoginLink =
            By.xpath("//a[contains(text(),'Signup / Login')]");

    public void clickProducts() {
        closePopupIfPresent();
        click(productsLink);
        WaitUtils.waitForUrlContains("/products");
    }

    public void clickCart() {
        closePopupIfPresent();
        click(cartLink);
    }

    public void clickSignupLogin() {
        closePopupIfPresent();
        click(signupLoginLink);
    }
}