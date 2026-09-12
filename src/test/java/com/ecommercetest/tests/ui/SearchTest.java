package com.ecommercetest.tests.ui;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.SearchPage;
import com.ecommercetest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchExistingProduct() {

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        homePage.clickProducts();

        searchPage.searchProduct("Blue Top");

        String heading =
                searchPage.getSearchedProductsHeading();

        Assert.assertTrue(
                heading.toLowerCase().contains("searched products"),
                "Searched Products heading should be displayed"
        );
    }
}