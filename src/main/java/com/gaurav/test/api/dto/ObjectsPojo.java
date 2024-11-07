package com.gaurav.test.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectsPojo {

    public ObjectsPojo(String name, Data data) {
        this.name = name;
        this.data = data;
    }
    @JsonProperty
    private String name;
    @JsonProperty
    private Data data;
}
