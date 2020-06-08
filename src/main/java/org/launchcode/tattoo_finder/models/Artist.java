package org.launchcode.tattoo_finder.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Artist extends AbstractEntity{

    @Size(max = 500, message = "Bio must be 500 characters or less")
    private String bio;

    private String shopLocation;

    private String style;

    public Artist(String bio, String shopLocation, String style) {
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
}
