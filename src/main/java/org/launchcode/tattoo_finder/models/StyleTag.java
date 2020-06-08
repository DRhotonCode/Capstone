package org.launchcode.tattoo_finder.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StyleTag extends AbstractEntity {

    @Size(min = 1, max = 25)
    @NotBlank
    private String name;

    public StyleTag(String name) {
        this.name = name;
    }

    public StyleTag(){}

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }

    public void setName(String name) {
        this.name = name;
    }
}
