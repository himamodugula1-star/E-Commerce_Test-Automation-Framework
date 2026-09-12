package com.ecommercetest.tests.api;

import com.ecommerce.api.AuthApi;
import com.ecommerce.config.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthApiTest {

    @Test
    public void verifyLoginApi() {

        ConfigReader configReader = new ConfigReader();

        String email =
                configReader.getProperty("email");

        String password =
                configReader.getProperty("password");

        AuthApi authApi = new AuthApi();

        Response response =
                authApi.verifyLogin(email, password);

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Verify Login API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody()
                        .asString()
                        .contains("User exists!"),
                "Response should confirm that the user exists"
        );
    }
}