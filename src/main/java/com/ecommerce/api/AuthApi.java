package com.ecommerce.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi {

    public Response verifyLogin(String email, String password) {

        return given()
                .spec(requestSpecification)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");
    }
    public Response createAccount(
            String name,
            String email,
            String password,
            String firstName,
            String lastName,
            String address,
            String country,
            String state,
            String city,
            String zipcode,
            String mobileNumber) {

        return given()
                .spec(requestSpecification)
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("firstname", firstName)
                .formParam("lastname", lastName)
                .formParam("address1", address)
                .formParam("country", country)
                .formParam("state", state)
                .formParam("city", city)
                .formParam("zipcode", zipcode)
                .formParam("mobile_number", mobileNumber)
                .when()
                .post("/api/createAccount");
    }
    public Response updateAccount(
            String name,
            String email,
            String password,
            String firstName,
            String lastName,
            String address,
            String country,
            String state,
            String city,
            String zipcode,
            String mobileNumber) {

        return given()
                .spec(requestSpecification)
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("firstname", firstName)
                .formParam("lastname", lastName)
                .formParam("address1", address)
                .formParam("country", country)
                .formParam("state", state)
                .formParam("city", city)
                .formParam("zipcode", zipcode)
                .formParam("mobile_number", mobileNumber)
                .when()
                .put("/api/updateAccount");
    }
    public Response deleteAccount(String email, String password) {

        return given()
                .spec(requestSpecification)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/deleteAccount");
    }
}