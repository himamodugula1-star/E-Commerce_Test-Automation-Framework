package com.ecommerce.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {

    public Response getUserDetailByEmail(String email) {

        return given()
                .spec(requestSpecification)
                .queryParam("email", email)
                .when()
                .get("/api/getUserDetailByEmail");
    }
}