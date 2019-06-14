package com.example.zeroc.fitness.model;

import java.io.Serializable;

public class Ex implements Serializable {

    private int exID;
    private String exTitle;
    private String exContent;

    public Ex() {
    }

    public Ex(int exID, String exTitle, String exContent) {
        this.exID = exID;
        this.exTitle = exTitle;
        this.exContent = exContent;
    }

    public Ex(String exTitle, String exContent) {
        this.exTitle = exTitle;
        this.exContent = exContent;
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
