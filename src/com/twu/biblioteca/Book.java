package com.twu.biblioteca;

/**
 * Created by amandeepsingh on 17/08/15.
 */
public class Book {
    private String name;
    private String author;
    private int yearOfPublication;
    private boolean available;

    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availability) {
        this.available = availability;
    }
}
