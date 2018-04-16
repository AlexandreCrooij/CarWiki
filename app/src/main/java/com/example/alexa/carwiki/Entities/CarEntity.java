package com.example.alexa.carwiki.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.Model.Owner;

import java.io.Serializable;

/**
 * Created by alexa on 23.03.2018.
 */
@Entity(tableName = "cars",
        foreignKeys = {
        @ForeignKey(
                entity = CarBrandEntity.class,
                parentColumns = "id_brand",
                childColumns = "id_owner"
        ),
        @ForeignKey(
                entity = OwnerEntity.class,
                parentColumns = "id_owner",
                childColumns = "id_owner"
        )
})
public class CarEntity implements Serializable{
    @PrimaryKey
    @ColumnInfo(name = "id_car")
    private int idCar;
    @ColumnInfo(name = "id_owner")
    private int idOwner;
    @ColumnInfo(name = "id_brand")
    private int idBrand;
    @ColumnInfo(name = "model")
    private String model;
    @ColumnInfo(name = "price")
    private float price;
    @ColumnInfo(name = "hubraum")
    private String hubraum;
    @ColumnInfo(name = "x_coord")
    private float xCoor;
    @ColumnInfo(name = "y_coord")
    private float yCoor;
    @ColumnInfo(name = "aufbau")
    private String aufbau;
    @ColumnInfo(name = "zylinder")
    private int zylinder;
    @ColumnInfo(name = "baujahr")
    private int baujahr;
    @ColumnInfo(name = "image_url")
    private String imageUrl;

    public CarEntity(int idCar, int idOwner, int idBrand, String model, float price, String hubraum, float xCoor, float yCoor, String aufbau, int zylinder, int baujahr, String imageUrl) {
        this.idCar = idCar;
        this.idOwner = idOwner;
        this.idBrand = idBrand;
        this.model = model;
        this.price = price;
        this.hubraum = hubraum;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.aufbau = aufbau;
        this.zylinder = zylinder;
        this.baujahr = baujahr;
        this.imageUrl = imageUrl;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getHubraum() {
        return hubraum;
    }

    public void setHubraum(String hubraum) {
        this.hubraum = hubraum;
    }

    public float getxCoor() {
        return xCoor;
    }

    public void setxCoor(float xCoor) {
        this.xCoor = xCoor;
    }

    public float getyCoor() {
        return yCoor;
    }

    public void setyCoor(float yCoor) {
        this.yCoor = yCoor;
    }

    public String getAufbau() {
        return aufbau;
    }

    public void setAufbau(String aufbau) {
        this.aufbau = aufbau;
    }

    public int getZylinder() {
        return zylinder;
    }

    public void setZylinder(int zylinder) {
        this.zylinder = zylinder;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
