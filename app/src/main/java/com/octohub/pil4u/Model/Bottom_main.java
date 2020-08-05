package com.octohub.pil4u.Model;

public class Bottom_main {

    String rate;
    String buildtype;
    String bathtubs;
    String beds;
    String sqft;
    int image;

    public Bottom_main(String rate, String buildtype, String bathtubs, String beds, String sqft, int image) {
        this.rate = rate;
        this.buildtype = buildtype;
        this.bathtubs = bathtubs;
        this.beds = beds;
        this.sqft = sqft;
        this.image = image;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBuildtype() {
        return buildtype;
    }

    public void setBuildtype(String buildtype) {
        this.buildtype = buildtype;
    }

    public String getBathtubs() {
        return bathtubs;
    }

    public void setBathtubs(String bathtubs) {
        this.bathtubs = bathtubs;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
