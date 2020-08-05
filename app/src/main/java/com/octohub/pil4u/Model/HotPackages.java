package com.octohub.pil4u.Model;

public class HotPackages {

    String cost;
    String buildingType;
    String location;
    String status;
    int images;

    public HotPackages(String cost, String buildingType, String location, String status, int images) {

        this.cost = cost;
        this.buildingType = buildingType;
        this.location = location;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
