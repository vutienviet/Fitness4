package com.example.zeroc.fitness.model;

public class DbResponse {
    public String image;
    public String name;

    public DbResponse(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public DbResponse() {
    }

    public DbResponse(String name) {
        this.name = name;
    }
}
