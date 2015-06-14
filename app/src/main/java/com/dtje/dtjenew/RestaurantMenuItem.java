package com.dtje.dtjenew;

/**
 * Created by User on 6/14/2015.
 */
public class RestaurantMenuItem {
    private String name, price;
    private int pic;

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setPrice(String p){
        price = p;
    }
    public String getPrice(){
        return price;
    }
    public void setPicture(int p){
        pic = p;
    }
    public int getPicture(){
        return pic;
    }
}