package com.example.demo.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CofetarieDTO {
    private int id_cofetarie;
    private String adresa_cofetarie;

    public int getId() {
        return id_cofetarie;
    }

    public void setId(int id) {
        this.id_cofetarie = id;
    }

    public String getAddress() {
        return adresa_cofetarie;
    }

    public void setAddress(String address) {
        this.adresa_cofetarie = address;
    }
}
