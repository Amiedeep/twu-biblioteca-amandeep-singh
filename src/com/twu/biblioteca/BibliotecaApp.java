package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    String welcomeMessage;
    ArrayList<Book> books;
    ArrayList<String> options;
    Scanner sc;

    public BibliotecaApp() {
        this.welcomeMessage = "Welcome to Bibliotecs App!";
        printWelcomeMessage();
        initialiseBooks();
        initialiseOptions();
    }

    public void initialiseBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("scjp", "kathy sierra", 2000));
        books.add(new Book("Head First Java", "Bert Bates", 2003));
    }

    public void initialiseOptions() {
        options = new ArrayList<String>();
        options.add("List Books");
        options.add("Check Out Book");
        options.add("Quit");
        printOptions();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.getAndPrintUserSelectedOption();
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    private void printWelcomeMessage() {
        System.out.println(getWelcomeMessage());
    }

    private void printBooks() {
        System.out.println("\nBooks available in library are:");
        System.out.printf("%-40s %-40s %-40s\n", "Name", "Author", "Year Of Publication");
        for(Book book : books) {
            System.out.printf("%-40s %-40s %-40s\n", book.getName(), book.getAuthor(), book.getYearOfPublication());
        }
    }

    private void getAndPrintUserSelectedOption() {

        sc = new Scanner(System.in);
        outer: while(true) {
            int optionNumber = sc.nextInt();
            switch(optionNumber) {
                case 1:
                    printBooks();
                    break;
                case 2:
                    System.out.println("Enter book name to checkout");
                    String bookToCheckOut= getBookNameToCheckout();
                    System.out.println(checkOutBook(bookToCheckOut));
                    printOptions();
                    break;
                case 3:
                    break outer;
                default:
                    System.out.println("Please Enter Valid Option!");
                    printOptions();
                    break;
            }
        }

    }

    public String checkOutBook(String bookToCheckOut) {
        for(Book book : books) {
            if(book.getName().equals(bookToCheckOut)) {
                books.remove(book);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available.";
    }

    public String getBookNameToCheckout() {

        return sc.next();
    }

    private void printOptions() {
        int index = 1;
        System.out.println("\nPlease select a option to proceed");
        for(String option : options) {
            System.out.println(index+": "+option);
            index++;
        }
    }
}
