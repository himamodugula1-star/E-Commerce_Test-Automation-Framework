package com.ecommercetest.tests.ui;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommercetest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickSignupLogin();

        loginPage.login(
                "valid@test.com",
                "Test@123"
        );

        // Assertion will be added after using valid test credentials.
    }
}