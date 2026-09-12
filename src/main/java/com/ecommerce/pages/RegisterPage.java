package com.ecommerce.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By nameField =
            By.xpath("//input[@data-qa='signup-name']");

    private final By emailField =
            By.xpath("//input[@data-qa='signup-email']");

    private final By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    private final By accountInformationHeading =
            By.xpath("//b[contains(translate(normalize-space(.), " +
                     "'abcdefghijklmnopqrstuvwxyz', " +
                     "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), " +
                     "'ENTER ACCOUNT INFORMATION')]");

    public void enterName(String name) {
        type(nameField, name);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void clickSignup() {
        click(signupButton);
    }

    public void startRegistration(String name, String email) {
        enterName(name);
        enterEmail(email);
        clickSignup();
    }

    public String getAccountInformationHeading() {
        return getText(accountInformationHeading);
    }
}