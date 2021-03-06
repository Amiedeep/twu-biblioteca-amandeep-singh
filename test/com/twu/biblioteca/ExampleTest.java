package com.twu.biblioteca;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    static BibliotecaApp testObject;

    @BeforeClass
    public static void setUp() {
        testObject = new BibliotecaApp();
        testObject.loggedInUser = new User("444-4555", "abcd", "Aman" , "amie@somewhere.com", 9888765437L);
    }

    @Test
    public void getWelcomeMessageTest() {
        assertThat(testObject.validateUser("111-2222", "abcd"), is(true));
        assertThat(testObject.validateUser("invalid user", "abcd"), is(false));
        assertThat(testObject.validateUser("111-2222", "invalid password"), is(false));
    }

    @Test
    public void initialiseUsersTest() {
        assertThat(testObject.users.size(), is(2));
        assertThat(testObject.users.get(0).getLibraryNumber(), is("111-2222"));
        assertThat(testObject.users.get(1).getLibraryNumber(), is("222-3333"));
        assertThat(testObject.users.get(0).getPassword(), is("abcd"));
        assertThat(testObject.users.get(1).getPassword(), is("abcd"));
    }

    @Test
    public void validateUserTest() {
        assertThat(testObject.getWelcomeMessage(), is("Welcome to Bibliotecs App!"));
    }

    @Test
    public void initialiseAppDataTest() {
        assertThat(testObject.books.size(), is(2));
        assertThat(testObject.movies.size(), is(2));
        assertThat(testObject.users.size(), is(2));
    }

    @Test
    public void initializeBooksTest() {
        assertThat(testObject.books.size(), is(2));
        assertThat(testObject.books.get(0).getAuthor(), is("kathy sierra"));
        assertThat(testObject.books.get(1).getAuthor(), is("Bert Bates"));
        assertThat(testObject.books.get(0).getYearOfPublication(), is(2000));
        assertThat(testObject.books.get(1).getYearOfPublication(), is(2003));
        assertThat(testObject.books.get(0).getName(), is("scjp"));
        assertThat(testObject.books.get(1).getName(), is("Head First Java"));
    }

    @Test
    public void initializeMoviesTest() {
        assertThat(testObject.movies.size(), is(2));
        assertThat(testObject.movies.get(0).getName(), is("Sholay"));
        assertThat(testObject.movies.get(1).getName(), is("Gadar"));
        assertThat(testObject.movies.get(0).getYear(), is(2000));
        assertThat(testObject.movies.get(1).getYear(), is(2001));
        assertThat(testObject.movies.get(0).getRating(), is(7.5f));
        assertThat(testObject.movies.get(1).getRating(), is(9.5f));
        assertThat(testObject.movies.get(0).getDirector(), is("Some One"));
        assertThat(testObject.movies.get(1).getDirector(), is("Some One again"));
    }

    @Test
    public void initializeOptionsTest() {
        testObject.initialiseOptions();
        assertThat(testObject.options.size(), is(7));
        assertThat(testObject.options.get(0), is("List Books"));
        assertThat(testObject.options.get(1), is("Check Out Book"));
        assertThat(testObject.options.get(2), is("Return Book"));
        assertThat(testObject.options.get(3), is("List Movies"));
        assertThat(testObject.options.get(4), is("Check Out Movie"));
        assertThat(testObject.options.get(5), is("Profile of logged in user"));
        assertThat(testObject.options.get(6), is("Quit"));
    }

    @Test
    public void checkOutBookTest() {
        assertThat(testObject.checkOutBook("Some invalid book") , is("That book is not available."));
        assertThat(testObject.books.get(0).isAvailable(), is(true));
        String bookToCheckout = testObject.books.get(0).getName();
        assertThat(testObject.checkOutBook(bookToCheckout) , is("Thank you! Enjoy the book"));
        assertThat(testObject.books.get(0).isAvailable(), is(false));
        assertThat(testObject.books.size(), is(2));
    }

    @Test
    public void checkOutMovieTest() {
        assertThat(testObject.checkOutMovie("Some invalid movie"), is("That movie is not available."));
        assertThat(testObject.movies.get(0).isAvailable(), is(true));
        String movieToCheckout = testObject.movies.get(0).getName();
        assertThat(testObject.checkOutMovie(movieToCheckout), is("Thank you! Enjoy the movie"));
        assertThat(testObject.movies.get(0).isAvailable(), is(false));
        assertThat(testObject.movies.size(), is(2));
    }

    @Test
    public void returnBookTest() {
        String bookToReturn = testObject.books.get(0).getName();
        testObject.checkOutBook(bookToReturn);
        assertThat(testObject.returnBook(bookToReturn), is("Thank you for returning the book."));
        assertThat(testObject.books.get(0).isAvailable(), is(true));
        assertThat(testObject.returnBook(bookToReturn), is("That is not a valid book to return."));
        assertThat(testObject.books.get(0).isAvailable(), is(true));
        assertThat(testObject.returnBook("some invalid book"), is("That is not a valid book to return."));
        assertThat(testObject.books.size(), is(2));
    }
}
