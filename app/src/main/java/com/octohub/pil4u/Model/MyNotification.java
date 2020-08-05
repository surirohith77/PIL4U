package com.octohub.pil4u.Model;

public class MyNotification {

    String name;
    String msg;
    String onlineStatus;
    String unReadMsgs;

    int images;

    public MyNotification(String name, String msg, String onlineStatus, String unReadMsgs, int images) {
        this.name = name;
        this.msg = msg;
        this.onlineStatus = onlineStatus;
        this.unReadMsgs = unReadMsgs;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getUnReadMsgs() {
        return unReadMsgs;
    }

    public void setUnReadMsgs(String unReadMsgs) {
        this.unReadMsgs = unReadMsgs;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
