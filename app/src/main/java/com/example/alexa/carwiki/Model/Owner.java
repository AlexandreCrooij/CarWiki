package com.example.alexa.carwiki.Model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by alexa on 23.03.2018.
 */

public class Owner implements Serializable{
    private int idOwner;
    private String prename;
    private String familyname;
    private String imageUrl;

    public Owner(int idOwner, String prename, String familyname, String imageUrl) {
        this.idOwner = idOwner;
        this.prename = prename;
        this.familyname = familyname;
        this.imageUrl = imageUrl;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
