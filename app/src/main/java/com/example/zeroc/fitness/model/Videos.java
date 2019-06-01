package com.example.zeroc.fitness.model;

public class Videos {
    private String title;
    private String thumbnail;
    private String id;

    public Videos(String title, String thumbnail, String id) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
