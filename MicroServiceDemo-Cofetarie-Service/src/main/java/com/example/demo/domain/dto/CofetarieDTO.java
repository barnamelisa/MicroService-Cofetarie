package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CofetarieDTO {
    private int id;
    @JsonProperty("address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
