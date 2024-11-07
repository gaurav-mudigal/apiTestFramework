package com.gaurav.test.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    public Data(int year, double price, String cpuModel, String hardDiskSize) {
        this.year = year;
        this.price = price;
        this.cpuModel = cpuModel;
        this.hardDiskSize = hardDiskSize;
    }

    @JsonProperty
    public int year;
    @JsonProperty
    public double price;
    @JsonProperty("CPU model")
    public String cpuModel;
    @JsonProperty("Hard disk size")
    public String hardDiskSize;


}
