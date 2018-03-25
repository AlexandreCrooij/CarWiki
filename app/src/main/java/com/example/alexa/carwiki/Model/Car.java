package com.example.alexa.carwiki.Model;

import java.io.Serializable;

/**
 * Created by alexa on 23.03.2018.
 */

public class Car implements Serializable{

    private int idCar;
    private int idOwner;
    private int idBrand;
    private Owner owner;
    private CarBrand carBrand;
    private String model;
    private float price;
    private String hubraum;
    private float xCoor;
    private float yCoor;
    private String aufbau;
    private int zylinder;
    private int baujahr;
    private String imageUrl;

    public Car(int idCar, int idOwner, int idBrand, Owner owner, CarBrand carBrand, String model, float price, String hubraum, float xCoor, float yCoor, String aufbau, int zylinder, int baujahr, String imageUrl) {
        this.idCar = idCar;
        this.idOwner = idOwner;
        this.idBrand = idBrand;
        this.owner = owner;
        this.carBrand = carBrand;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }
}
