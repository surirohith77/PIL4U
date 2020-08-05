package com.octohub.pil4u.Model;

public class Favorites {

    String cost;
    String buildingType;
    String location;

    int images;

    public Favorites(String cost, String buildingType, String location, int images) {
        this.cost = cost;
        this.buildingType = buildingType;
        this.location = location;
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
}
