package org.launchcode.tattoo_finder.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Artist extends AbstractEntity{

    @NotNull
    @NotBlank
    private String name;

    @Size(max = 500, message = "Bio must be 500 characters or less")
    private String bio;

    private String shopLocation;

    private String style;

    public Artist(String name, String bio, String shopLocation, String style) {
        this.name = name;
        this.bio = bio;
        this.shopLocation = shopLocation;
        this.style = style;
    }

    public Artist(){}

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
