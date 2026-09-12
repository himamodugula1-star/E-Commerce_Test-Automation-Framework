package com.ecommerce.pages;

import com.ecommerce.utils.WaitUtils;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By firstProductViewButton =
            By.xpath("(//a[contains(text(),'View Product')])[1]");

    private final By productName =
            By.xpath("//div[@class='product-information']//h2");

    private final By productPrice =
            By.xpath("//div[@class='product-information']//span[1]");

    private final By quantityInput =
            By.id("quantity");

    private final By addToCartButton =
            By.xpath("//button[contains(@class,'cart')]");

    private final By addToCartConfirmation =
            By.xpath("//div[contains(@class,'modal-content')]");

    private final By viewCartButton =
            By.xpath("//div[contains(@class,'modal-content')]//a[contains(@href,'view_cart')]");

    public void clickFirstProduct() {
        click(firstProductViewButton);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void enterQuantity(String quantity) {
        clear(quantityInput);
        type(quantityInput, quantity);
    }

    public void addProductToCart() {
        click(addToCartButton);
        WaitUtils.waitForVisibility(addToCartConfirmation);
    }

    public void clickViewCart() {
        click(viewCartButton);
    }
}