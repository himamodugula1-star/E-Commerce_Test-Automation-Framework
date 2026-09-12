package com.ecommercetest.tests.ui;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommercetest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductAndAddToCart() {

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        // Navigate to Products
        homePage.clickProducts();

        // Open the first product
        productPage.clickFirstProduct();

        // Capture product details
        String productName =
                productPage.getProductName();

        String productPrice =
                productPage.getProductPrice();

        Assert.assertFalse(
                productName.isEmpty(),
                "Product name should be displayed"
        );

        Assert.assertFalse(
                productPrice.isEmpty(),
                "Product price should be displayed"
        );

        // Add product to cart
        productPage.addProductToCart();

        // Wait for confirmation and open cart
        productPage.clickViewCart();

        // Verify product is present in cart
        String cartProductName =
                cartPage.getProductName();

        Assert.assertEquals(
                cartProductName,
                productName,
                "Added product should be displayed in the cart"
        );
    }
}