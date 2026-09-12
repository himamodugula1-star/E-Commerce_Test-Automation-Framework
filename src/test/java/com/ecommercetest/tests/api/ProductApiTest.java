package com.ecommercetest.tests.api;

import com.ecommerce.api.ProductApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductApiTest {

    @Test
    public void verifyProductsListApi() {

        ProductApi productApi = new ProductApi();

        Response response = productApi.getProducts();

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Products API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody().asString().contains("products"),
                "Response should contain products data"
        );
    }
}