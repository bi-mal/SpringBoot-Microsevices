package com.example.moviecatalogue.model;

public class CatalogItem {
    private String name;
    private String movieId;
    private String desc;
    private int rating;

    public CatalogItem(String name, String movieId, String desc, int rating) {
        this.name = name;
        this.movieId = movieId;
        this.desc = desc;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
