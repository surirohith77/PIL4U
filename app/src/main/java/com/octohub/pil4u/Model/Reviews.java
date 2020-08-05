package com.octohub.pil4u.Model;

public class Reviews {

    String name;
    String date;
    String Review;
    int image;

    public Reviews(String name, String date, String review, int image) {
        this.name = name;
        this.date = date;
        Review = review;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
