package com.dtje.dtjenew;

import java.io.Serializable;

/**
 * Created by User on 6/13/2015.
 */
public class Restaurant implements Serializable  {
    String name, distance, price, contact,description ;
    int rating, picture;

    public void setPicture(int p) {picture = p;}

    public int getPicture() {return picture;}

    public void setName(String n) {name = n;}

    public String getName() {return name;}

    public void setDistance(String d) {
        distance = d;
    }

    public String getDistance() {return distance;}

    public void setPrice(String p) {
        price = p;
    }

    public String getPrice() {return price;}

    public void setRating(int r) {
        rating = r;
    }

    public int getRating() {
        return rating;
    }

    public void setContact(String c) {contact = c;}

    public String getContact() {return contact;}

    public void setDescription(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }
}
