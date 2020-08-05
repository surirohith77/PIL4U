package com.octohub.pil4u.Model;

public class FeaturedProperties {

    String cost;
    String buildingType;
    String beds;
    String baths;
    String sqrt;

    int images;

    public FeaturedProperties(String cost, String buildingType, String beds, String baths, String sqrt, int images) {
        this.cost = cost;
        this.buildingType = buildingType;
        this.beds = beds;
        this.baths = baths;
        this.sqrt = sqrt;
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

    public String getSqrt() {
        return sqrt;
    }

    public void setSqrt(String sqrt) {
        this.sqrt = sqrt;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
