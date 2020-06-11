package org.launchcode.tattoo_finder.models;

import java.util.ArrayList;

public class ArtistInfo {

    public static ArrayList<Artist> findByColumnAndValue(String column, String value, Iterable<Artist> allArtists) {

        ArrayList<Artist> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Artist>) allArtists;
        }

        if (column.equals("all")){
            results = findByValue(value, allArtists);
            return results;
        }
        for (Artist artist : allArtists) {

            String aValue = getFieldValue(artist, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(artist);
            }
        }

        return results;
    }

    public static String getFieldValue(Artist artist, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = artist.getName();
        } else if (fieldName.equals("styles")){
            theValue = artist.getStyles().toString();
        } else {
            theValue = artist.getLocation();
        }

        return theValue;
    }

    public static ArrayList<Artist> findByValue(String value, Iterable<Artist> allArtists) {
        String lower_val = value.toLowerCase();

        ArrayList<Artist> results = new ArrayList<>();

        for (Artist artist : allArtists) {

            if (artist.getName().toLowerCase().contains(lower_val)) {
                results.add(artist);
            } else if (artist.getStyles().toString().toLowerCase().contains(lower_val)) {
                results.add(artist);
            } else if (artist.toString().toLowerCase().contains(lower_val)) {
                results.add(artist);
            } else if (artist.getLocation().toLowerCase().contains(lower_val)) {
                results.add(artist);
            }

        }

        return results;
    }


}
