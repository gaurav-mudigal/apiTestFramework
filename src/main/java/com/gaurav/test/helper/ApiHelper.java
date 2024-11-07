package com.gaurav.test.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gaurav.test.base.BaseApi;
import com.gaurav.test.base.GetMethod;
import com.gaurav.test.base.PostMethod;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static com.gaurav.test.helper.Constants.DELIMITER;
import static com.gaurav.test.utils.JsonUtils.serializer;

public class ApiHelper {

    public synchronized static Response callPostApi(String baseUri, String basePath, Object requestBody) throws JsonProcessingException {
        return new BaseApi(new RequestSpecBuilder().setBaseUri(baseUri)
                .setBasePath(basePath)
                .setBody(serializer(requestBody))
                .addHeader("Content-Type", "application/json")).execute(new PostMethod());
    }

    public synchronized static Response callGetApi(String baseUri, String basePath, String id) {
        return new BaseApi(new RequestSpecBuilder().setBaseUri(baseUri)
                .setBasePath(basePath+ DELIMITER + id)
                .addHeader("Content-Type", "application/json")).execute(new GetMethod());
    }
}
