package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    String welcomeMessage;
    public ArrayList<Book> books;
    public ArrayList<String> options;
    private Scanner sc;
    public ArrayList<Movie> movies;

    public BibliotecaApp() {
        this.welcomeMessage = "Welcome to Bibliotecs App!";
        printWelcomeMessage();
        initialiseBooks();
        initialiseMovies();
        initialiseOptions();
    }

    public void initialiseBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("scjp", "kathy sierra", 2000));
        books.add(new Book("Head First Java", "Bert Bates", 2003));
    }

    public void initialiseMovies() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Sholay", 2000, "Some One", 7.5f));
        movies.add(new Movie("Gadar", 2001, "Some One again", 9.5f));
    }

    public void initialiseOptions() {
        options = new ArrayList<String>();
        options.add("List Books");
        options.add("Check Out Book");
        options.add("Return Book");
        options.add("List Movies");
        options.add("Check Out Movie");
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

    private void printMovies() {
        System.out.println("\nMovies available in library are:");
        System.out.printf("%-40s %-40s %-40s %-40s\n", "Name", "Year", "Director", "Rating");
        for(Movie movie : movies) {
            System.out.printf("%-40s %-40s %-40s %-40s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
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
                    String bookNameToCheckout= getBookNameToCheckout();
                    System.out.println(checkOutBook(bookNameToCheckout));
                    printOptions();
                    break;
                case 3:
                    System.out.println("Enter book name to return");
                    String bookNameToReturn = getBookNameToReturn();
                    System.out.println(returnBook(bookNameToReturn));
                    printOptions();
                    break;
                case 4:
                    printMovies();
                    break;
                case 5:
                    System.out.println("Enter movie name to checkout");
                    String movieToCheckOut= getMovieNameToCheckout();
                    System.out.println(checkOutMovie(movieToCheckOut));
                    printOptions();
                    break;
                case 6:
                    break outer;
                default:
                    System.out.println("Please Enter Valid Option!");
                    printOptions();
                    break;
            }
        }

    }

    public String returnBook(String bookNameToreturn) {
        for(Book book : books) {
            if(book.getName().equals(bookNameToreturn) && !book.isAvailable()) {
                book.setAvailable(true);
                return "Thank you for returning the book.";
            }
        }
        return "That is not a valid book to return.";
    }

    public String checkOutBook(String bookToCheckOut) {
        for(Book book : books) {
            if(book.getName().equals(bookToCheckOut) && book.isAvailable()) {
                book.setAvailable(false);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available.";
    }

    public String checkOutMovie(String movieToCheckOut) {
        for(Movie movie : movies) {
            if(movie.getName().equals(movieToCheckOut) && movie.isAvailable()) {
                movie.setAvailable(false);
                return "Thank you! Enjoy the movie";
            }
        }
        return "That movie is not available.";
    }

    private String getBookNameToCheckout() {

        return sc.next();
    }

    private String getMovieNameToCheckout() {

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

    private String getBookNameToReturn() {
        return sc.next();
    }
}
