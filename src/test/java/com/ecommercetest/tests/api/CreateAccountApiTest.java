package com.ecommercetest.tests.api;

import com.ecommerce.api.AuthApi;
import com.ecommerce.utils.RandomdataUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountApiTest {

    @Test
    public void verifyCreateAccountApi() {

        AuthApi authApi = new AuthApi();

        String email =
                RandomdataUtils.generateRandomEmail();

        Response response =
                authApi.createAccount(
                        "ApiTestUser",
                        email,
                        "ApiTest@123",
                        "Api",
                        "Test",
                        "Test Address",
                        "India",
                        "Telangana",
                        "Hyderabad",
                        "500001",
                        "9876543210"
                );

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Create Account API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody()
                        .asString()
                        .contains("User created!"),
                "Response should confirm that the user was created"
        );
    }
}