package com.example.zeroc.fitness.model;

public class Item {
//    private String nameLession;
//    private String imageLession;
//    private String durations;
//
//    public Item() {
//
//    }
//
//    public Item(String nameLession, String imageLession, String durations) {
//        this.nameLession = nameLession;
//        this.imageLession = imageLession;
//        this.durations = durations;
//    }
//
//    public String getNameLession() {
//        return nameLession;
//    }
//
//    public void setNameLession(String nameLession) {
//        this.nameLession = nameLession;
//    }
//
//    public String getImageLession() {
//        return imageLession;
//    }
//
//    public void setImageLession(String imageLession) {
//        this.imageLession = imageLession;
//    }
//
//    public String getDurations() {
//        return durations;
//    }
//
//    public void setDurations(String durations) {
//        this.durations = durations;
//    }
//
//    @Override
//    public String toString() {
//        return "item{" +
//                "nameLession='" + nameLession + '\'' +
//                ", durations=" + durations +
//                '}';
//    }

    private int img_id;
    private String name;
    private int id;

    public Item(int img_id, String name) {
        this.img_id = img_id;
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
