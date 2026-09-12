package com.ecommercetest.tests.api;

import com.ecommerce.api.AuthApi;
import com.ecommerce.utils.RandomdataUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountApiTest {

    @Test
    public void verifyDeleteAccountApi() {

        AuthApi authApi = new AuthApi();

        // Create a dedicated temporary account
        String email =
                RandomdataUtils.generateRandomEmail();

        String password = "DeleteTest@123";

        Response createResponse =
                authApi.createAccount(
                        "DeleteTestUser",
                        email,
                        password,
                        "Delete",
                        "Test",
                        "Delete Test Address",
                        "India",
                        "Telangana",
                        "Hyderabad",
                        "500001",
                        "9876543210"
                );

        Assert.assertEquals(
                createResponse.getStatusCode(),
                200,
                "Temporary account should be created successfully"
        );

        // Delete the temporary account
        Response deleteResponse =
                authApi.deleteAccount(
                        email,
                        password
                );

        Assert.assertEquals(
                deleteResponse.getStatusCode(),
                200,
                "Delete Account API should return HTTP 200"
        );

        Assert.assertTrue(
                deleteResponse.getBody()
                        .asString()
                        .contains("Account deleted!"),
                "Response should confirm that the account was deleted"
        );
    }
}