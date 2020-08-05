package com.octohub.pil4u.Model;

public class Ads {


    String cost;
    String sqft;
    String location;
    String beds;
    String baths;
    int images;

    public Ads(String cost,  String location, String beds, String baths,String sqft, int images) {
        this.cost = cost;
        this.sqft = sqft;
        this.location = location;
        this.beds = beds;
        this.baths = baths;
        this.images = images;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
