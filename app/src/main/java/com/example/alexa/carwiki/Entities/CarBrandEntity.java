package com.example.alexa.carwiki.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by alexa on 23.03.2018.
 */

@Entity(tableName = "brands")
public class CarBrandEntity implements Serializable{
    @PrimaryKey
    @ColumnInfo(name = "id_brand")
    private int idBrand;
    @ColumnInfo(name = "id_category")
    private String category;
    @ColumnInfo(name = "id_information")
    private String information;
    @ColumnInfo(name = "id_description")
    private String descripion;
    @ColumnInfo(name = "id_logoUrl")
    private String logoUrl;

    public CarBrandEntity(int idBrand, String category, String descripion, String information, String logoUrl) {
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
