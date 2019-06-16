package com.example.zeroc.fitness.model;

import java.io.Serializable;

public class Ex implements Serializable {

    private int exID;
    private int image;
    private String exTitle;
    private String exContent;

    public Ex() {
    }


    public Ex(int image, String exTitle) {
        this.image = image;
        this.exTitle = exTitle;
    }

    public Ex(String exTitle) {
        this.exTitle = exTitle;
    }

    public Ex(int exID, int image, String exTitle) {
        this.exID = exID;
        this.image = image;
        this.exTitle = exTitle;
    }

    public Ex(int exID, byte parseByte, String string, String string1) {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getExID() {
        return exID;
    }

    public void setExID(int exID) {
        this.exID = exID;
    }

    public String getExTitle() {
        return exTitle;
    }

    public void setExTitle(String exTitle) {
        this.exTitle = exTitle;
    }

    public String getExContent() {
        return exContent;
    }

    public void setExContent(String exContent) {
        this.exContent = exContent;
    }
}
