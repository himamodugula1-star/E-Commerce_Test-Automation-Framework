package com.ecommerce.api;

import com.ecommerce.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected final ConfigReader configReader;
    protected final RequestSpecification requestSpecification;

    public BaseApi() {

        configReader = new ConfigReader();

        String baseUrl =
                configReader.getProperty("api.base.url");

        requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .build();
    }
}