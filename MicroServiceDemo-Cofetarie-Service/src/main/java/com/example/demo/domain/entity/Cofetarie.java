package com.example.demo.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cofetarie")
public class Cofetarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cofetarie")
    private int id_cofetarie;
    @Column(name = "adresa_cofetarie")
    private String adresa_cofetarie;

    public int getId() {
        return id_cofetarie;
    }

    public void setId(int id) {
        this.id_cofetarie = id;
    }

    public String getAdresaCofetarie() {
        return adresa_cofetarie;
    }

    public void setAdresaCofetarie(String adresa_cofetarie) {
        this.adresa_cofetarie = adresa_cofetarie;
    }

}
