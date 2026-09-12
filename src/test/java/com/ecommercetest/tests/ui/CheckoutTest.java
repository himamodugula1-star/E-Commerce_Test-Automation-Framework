package com.ecommercetest.tests.ui;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductPage;
import com.ecommercetest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutAndPlaceOrder() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // 1. Navigate to Login
        homePage.clickSignupLogin();

        // 2. Login with test user
        loginPage.login(
                configReader.getProperty("email"),
                configReader.getProperty("password")
        );

        // 3. Navigate to Products
        homePage.clickProducts();

        // 4. Open first product
        productPage.clickFirstProduct();

        // 5. Add product to cart
        productPage.addProductToCart();

        // 6. Open cart from confirmation modal
        productPage.clickViewCart();

        // 7. Proceed to checkout
        cartPage.proceedToCheckout();

        // 8. Enter order comment
        checkoutPage.enterComment(
                "Please process the order"
        );

        // 9. Place order
        checkoutPage.placeOrder();

        // 10. Enter payment details
        checkoutPage.enterCardDetails(
                "Test User",
                "4111111111111111",
                "123",
                "12",
                "2030"
        );

        // 11. Pay and confirm order
        checkoutPage.payAndConfirmOrder();

        // 12. Verify order confirmation
        String confirmationMessage =
                checkoutPage.getOrderConfirmationMessage();

        Assert.assertTrue(
                confirmationMessage.contains(
                        "Congratulations! Your order has been confirmed!"
                ),
                "Order confirmation message should be displayed"
        );
    }
}