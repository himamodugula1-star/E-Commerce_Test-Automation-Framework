package com.ecommercetest.tests.ui;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.RegisterPage;
import com.ecommercetest.tests.BaseTest;
import com.ecommerce.utils.RandomdataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() {

        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        String name = "TestUser";

        String email =
                RandomdataUtils.generateRandomEmail();

        homePage.clickSignupLogin();

        registerPage.startRegistration(name, email);

        String heading =
                registerPage.getAccountInformationHeading();

        Assert.assertTrue(
                heading.toLowerCase().contains("enter account information"),
                "Account Information page should be displayed. Actual heading: "
                + heading
        );
    }
}