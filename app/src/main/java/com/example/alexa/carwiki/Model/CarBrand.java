package com.example.alexa.carwiki.Model;

import java.io.Serializable;

/**
 * Created by alexa on 23.03.2018.
 */

public class CarBrand implements Serializable{
    private int idBrand;
    private String category;
    private String information;
    private String descripion;
    private String logoUrl;

    public CarBrand(int idBrand, String category, String descripion, String information, String logoUrl) {
        this.idBrand = idBrand;
        this.category = category;
        this.information = information;
        this.descripion = descripion;
        this.logoUrl = logoUrl;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

}
