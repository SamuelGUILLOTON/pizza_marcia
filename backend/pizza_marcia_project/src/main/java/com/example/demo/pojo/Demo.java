package com.example.demo.pojo;


public class Demo {

    private String libelle;

    private Integer poid;


    public Demo() {
    }

    public Demo(String libelle, Integer poid) {
        this.libelle = libelle;
        this.poid = poid;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
