package com.ecommercetest.tests.ui;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommercetest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartProductQuantity() {

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        homePage.clickProducts();

        productPage.clickFirstProduct();

        productPage.enterQuantity("2");

        productPage.addProductToCart();

        homePage.clickCart();

        String quantity =
                cartPage.getProductQuantity();

        Assert.assertEquals(
                quantity,
                "2",
                "Cart product quantity should be 2"
        );
    }

    @Test
    public void removeProductFromCart() {

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        homePage.clickProducts();

        productPage.clickFirstProduct();

        productPage.addProductToCart();

        homePage.clickCart();

        cartPage.removeProduct();

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart should be empty after removing the product"
        );
    }
}