package com.octohub.pil4u.Model;

public class FloorPlans {

    String floor;
    String size;
    String rooms;
    String baths;
    String price;

    public FloorPlans(String floor, String size, String rooms, String baths, String price) {
        this.floor = floor;
        this.size = size;
        this.rooms = rooms;
        this.baths = baths;
        this.price = price;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
