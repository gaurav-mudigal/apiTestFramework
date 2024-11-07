package com.gaurav.test.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod implements HttpMethods{

    @Override
    public Response execute(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).post();
    }
}