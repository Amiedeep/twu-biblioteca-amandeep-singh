package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by amandeepsingh on 20/08/15.
 */
public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String emailAddress;
    private Long phoneNumber;
    private ArrayList<Book> checkedOutBooks;


    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void addCheckedOutBook(Book checkedOutBook) {
        checkedOutBooks.add(checkedOutBook);
    }

    public void returnCheckedOutBook(Book returnCheckedOutBook) {
        checkedOutBooks.remove(returnCheckedOutBook);
    }

    public User(String libraryNumber, String password, String name, String emailAddress, Long phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
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

    public void seeLoggedInUser() {
        System.out.println("Name of user is: "+this.getName());
        System.out.println("Email address of user is: "+this.getEmailAddress());
        System.out.println("Phone number of user is: "+this.getPhoneNumber());
    }
}
