package com.ecommerce.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartProductName =
            By.xpath("//td[@class='cart_description']//h4/a");

    private final By cartProductPrice =
            By.xpath("//td[@class='cart_price']//p");

    private final By cartProductQuantity =
            By.xpath("//td[@class='cart_quantity']//button");

    private final By cartProductTotal =
            By.xpath("//td[@class='cart_total']//p");

    private final By removeProductButton =
            By.xpath("//a[@class='cart_quantity_delete']");

    private final By proceedToCheckoutButton =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    private final By emptyCartMessage =
            By.xpath("//b[contains(text(),'Cart is empty!')]");

    public String getProductName() {
        return getText(cartProductName);
    }

    public String getProductPrice() {
        return getText(cartProductPrice);
    }

    public String getProductQuantity() {
        return getText(cartProductQuantity);
    }

    public String getProductTotal() {
        return getText(cartProductTotal);
    }

    public void removeProduct() {
        click(removeProductButton);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutButton);
    }

    public boolean isCartEmpty() {
        return getDriver().findElements(emptyCartMessage).size() > 0;
    }
}