package com.ecommerce.pages;

import com.ecommerce.utils.WaitUtils;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private final By searchInput =
            By.id("search_product");

    private final By searchButton =
            By.id("submit_search");

    private final By searchedProductsHeading =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    public void enterSearchText(String productName) {
        WaitUtils.waitForPresence(searchInput);
        type(searchInput, productName);
    }

    public void clickSearch() {
        click(searchButton);
    }

    public void searchProduct(String productName) {
        closePopupIfPresent();
        enterSearchText(productName);
        clickSearch();
    }

    public String getSearchedProductsHeading() {
        return getText(searchedProductsHeading);
    }
}