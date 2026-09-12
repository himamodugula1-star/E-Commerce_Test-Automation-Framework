package com.ecommercetest.tests.api;

import com.ecommerce.api.AuthApi;
import com.ecommerce.config.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateAccountApiTest {

    @Test
    public void verifyUpdateAccountApi() {

        ConfigReader configReader = new ConfigReader();

        String email =
                configReader.getProperty("email");

        String password =
                configReader.getProperty("password");

        AuthApi authApi = new AuthApi();

        Response response =
                authApi.updateAccount(
                        "UpdatedApiUser",
                        email,
                        password,
                        "Updated",
                        "User",
                        "Updated Test Address",
                        "India",
                        "Telangana",
                        "Hyderabad",
                        "500001",
                        "9876543210"
                );

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Update Account API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody()
                        .asString()
                        .contains("User updated!"),
                "Response should confirm that the user was updated"
        );
    }
}