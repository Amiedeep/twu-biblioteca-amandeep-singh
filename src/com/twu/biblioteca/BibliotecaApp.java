package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    String welcomeMessage;

    public BibliotecaApp() {
        this.welcomeMessage = "Welcome to Bibliotecs App!";
        printWelcomeMessage();
        printBooks();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public List<String> getBooks() {
        List<String> books = new ArrayList<String>();
        books.add("Head First Java");
        books.add("scjp");
        return books;
    }

    private void printWelcomeMessage() {
        System.out.println(getWelcomeMessage());
    }

    private void printBooks() {
        System.out.println("\nBooks available in library are:\n"+getBooks());
    }

}
