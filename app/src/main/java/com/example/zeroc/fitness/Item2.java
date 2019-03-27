package com.example.zeroc.fitness;

public class Item2 {
    private String nameReport;
    private String imageReport;
    private String durationsReport;

    public Item2() {
    }

    public Item2(String nameReport, String imageReport, String durationsReport) {
        this.nameReport = nameReport;
        this.imageReport = imageReport;
        this.durationsReport = durationsReport;
    }

    public String getNameReport() {
        return nameReport;
    }

    public void setNameReport(String nameReport) {
        this.nameReport = nameReport;
    }

    public String getImageReport() {
        return imageReport;
    }

    public void setImageReport(String imageReport) {
        this.imageReport = imageReport;
    }

    public String getDurationsReport() {
        return durationsReport;
    }

    public void setDurationsReport(String durationsReport) {
        this.durationsReport = durationsReport;
    }

    @Override
    public String toString() {
        return "item2{" +
                "nameReport='" + nameReport + '\'' +
                ", durationsReprot=" + durationsReport +
                '}';
    }
}
