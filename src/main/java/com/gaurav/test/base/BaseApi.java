package com.gaurav.test.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    private final RequestSpecBuilder requestSpecBuilder;

    public BaseApi(RequestSpecBuilder requestSpecBuilder){
        this.requestSpecBuilder = requestSpecBuilder;
        requestSpecBuilder.addFilter(new RequestLoggingFilter());
        requestSpecBuilder.addFilter(new ResponseLoggingFilter());
    }

    public Response execute(HttpMethods httpMethods){
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification requestSpecification = requestSpecBuilder.build();
        return httpMethods.execute(requestSpecification);
    }
}
