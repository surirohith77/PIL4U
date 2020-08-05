package com.octohub.pil4u.Model;

public class PopularHouses {

    String cost;
    String buildingType;
    String location;
    String rating;
    int images;

    public PopularHouses(String cost, String buildingType, String location, String rating, int images) {
        this.cost = cost;
        this.buildingType = buildingType;
        this.location = location;
        this.rating = rating;
        this.images = images;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
