package org.launchcode.tattoo_finder.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist extends AbstractEntity{

    @NotNull
    @NotBlank
    private String name;

    @Size(max = 500, message = "Bio must be 500 characters or less")
    private String bio;

    private String Location;

    @ManyToMany
    private List<Style> styles = new ArrayList<>();

    public Artist(String name, String bio, String Location, List<Style> styles) {
        this.name = name;
        this.bio = bio;
        this.Location = Location;
        this.styles = styles;
    }

    public Artist(){}

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String shopLocation) {
        this.Location = shopLocation;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
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
