package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by amandeepsingh on 20/08/15.
 */
public class User {
    private String libraryNumber;
    private String password;
    private ArrayList<Book> checkedOutBooks;

    public void addCheckedOutBook(Book checkedOutBook) {
        checkedOutBooks.add(checkedOutBook);
    }

    public void returnCheckedOutBook(Book returnCheckedOutBook) {
        checkedOutBooks.remove(returnCheckedOutBook);
    }

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.checkedOutBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
