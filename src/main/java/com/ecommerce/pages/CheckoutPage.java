package com.ecommerce.pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By commentTextArea =
            By.xpath("//textarea[@name='message']");

    private final By placeOrderButton =
            By.xpath("//a[contains(text(),'Place Order')]");

    private final By nameOnCard =
            By.xpath("//input[@name='name_on_card']");

    private final By cardNumber =
            By.xpath("//input[@name='card_number']");

    private final By cvc =
            By.xpath("//input[@name='cvc']");

    private final By expiryMonth =
            By.xpath("//input[@name='expiry_month']");

    private final By expiryYear =
            By.xpath("//input[@name='expiry_year']");

    private final By payAndConfirmOrderButton =
            By.xpath("//button[@id='submit']");

    private final By orderConfirmationMessage =
            By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");

    public void enterComment(String comment) {
        type(commentTextArea, comment);
    }

    public void placeOrder() {
        click(placeOrderButton);
    }

    public void enterCardDetails(
            String name,
            String cardNumberValue,
            String cvcValue,
            String month,
            String year) {

        type(nameOnCard, name);
        type(cardNumber, cardNumberValue);
        type(cvc, cvcValue);
        type(expiryMonth, month);
        type(expiryYear, year);
    }

    public void payAndConfirmOrder() {
        click(payAndConfirmOrderButton);
    }

    public String getOrderConfirmationMessage() {
        return getText(orderConfirmationMessage);
    }
}