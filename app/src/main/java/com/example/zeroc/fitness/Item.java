package com.example.zeroc.fitness;

public class Item {
    private String nameLession;
    private String imageLession;
    private int durations;

    public Item() {

    }

    public Item(String nameLession, String imageLession, int durations) {
        this.nameLession = nameLession;
        this.imageLession = imageLession;
        this.durations = durations;
    }

    public String getNameLession() {
        return nameLession;
    }

    public void setNameLession(String nameLession) {
        this.nameLession = nameLession;
    }

    public String getImageLession() {
        return imageLession;
    }

    public void setImageLession(String imageLession) {
        this.imageLession = imageLession;
    }

    public int getDurations() {
        return durations;
    }

    public void setDurations(int durations) {
        this.durations = durations;
    }

    @Override
    public String toString() {
        return "item{" +
                "nameLession='" + nameLession + '\'' +
                ", durations=" + durations +
                '}';
    }
}
