package com.octohub.pil4u.Model;

public class Features  {

    String features ;
    int  badge ;
    int images;

    public Features(String features, int badge, int images) {
        this.features = features;
        this.badge = badge;
        this.images = images;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
