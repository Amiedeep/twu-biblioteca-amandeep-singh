package com.twu.biblioteca;

/**
 * Created by amandeepsingh on 20/08/15.
 */
public class Movie {
    private String name;
    private int year;
    private float rating;
    private String director;
    private boolean available;

    public Movie(String name, int year, String director, float rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public float getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
