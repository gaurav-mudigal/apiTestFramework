package com.gaurav.test.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface HttpMethods {

    Response execute(RequestSpecification requestSpecification);
}
