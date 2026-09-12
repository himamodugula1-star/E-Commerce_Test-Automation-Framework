package com.ecommercetest.tests.api;

import com.ecommerce.api.UserApi;
import com.ecommerce.config.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserDetailApiTest {

    @Test
    public void verifyGetUserDetailApi() {

        ConfigReader configReader = new ConfigReader();

        String email =
                configReader.getProperty("email");

        UserApi userApi = new UserApi();

        Response response =
                userApi.getUserDetailByEmail(email);

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Get User Detail API should return HTTP 200"
        );

        Assert.assertTrue(
                response.getBody()
                        .asString()
                        .contains(email),
                "Response should contain the requested user's email"
        );
    }
}