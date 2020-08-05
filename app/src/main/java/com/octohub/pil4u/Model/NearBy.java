package com.octohub.pil4u.Model;

public class NearBy  {

    String nameDistance;
    String rating;
    String review;

    public NearBy(String nameDistance, String rating, String review) {
        this.nameDistance = nameDistance;
        this.rating = rating;
        this.review = review;

    }

    public String getNameDistance() {
        return nameDistance;
    }

    public void setNameDistance(String nameDistance) {
        this.nameDistance = nameDistance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
