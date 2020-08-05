package com.octohub.pil4u.Model;

public class Offers {

    String offers;

    int image;

    public Offers(String offers, int image) {
        this.offers = offers;
        this.image = image;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
