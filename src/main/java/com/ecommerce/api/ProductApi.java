package com.ecommerce.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductApi extends BaseApi {

    public Response getProducts() {

        return given()
                .spec(requestSpecification)
                .when()
                .get("/api/productsList");
    }
    public Response searchProduct(String productName) {

        return given()
                .spec(requestSpecification)
                .formParam("search_product", productName)
                .when()
                .post("/api/searchProduct");
    }
}