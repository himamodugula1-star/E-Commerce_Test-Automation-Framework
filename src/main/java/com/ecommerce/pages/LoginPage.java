package com.ecommerce.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailField =
            By.xpath("//input[@data-qa='login-email']");

    private final By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    private final By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    private final By loginErrorMessage =
            By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessage);
    }
}