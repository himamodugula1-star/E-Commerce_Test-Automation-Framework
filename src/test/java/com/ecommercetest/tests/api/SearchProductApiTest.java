package com.ecommercetest.tests.api;

import com.ecommerce.api.ProductApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductApiTest {

    @Test
    public void verifySearchProductApi() {

        ProductApi productApi = new ProductApi();

        Response response =
                productApi.searchProduct("Blue Top");

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Search Product API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody()
                        .asString()
                        .contains("Blue Top"),
                "Response should contain the searched product"
        );
    }
}