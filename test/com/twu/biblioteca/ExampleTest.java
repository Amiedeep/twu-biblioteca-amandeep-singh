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
    }

    @Test
    public void getWelcomeMessageTest() {
        assertThat(testObject.getWelcomeMessage(), is("Welcome to Bibliotecs App!"));
    }

    @Test
    public void initializeBooksTest() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("scjp", "kathy sierra", 2000));
        books.add(new Book("Head First Java", "Bert Bates", 2003));
        testObject.initialiseBooks();
        assertThat(testObject.books.size(), is(2));
        assertThat(testObject.books.get(0).getAuthor(), is("kathy sierra"));
        assertThat(testObject.books.get(1).getAuthor(), is("Bert Bates"));
        assertThat(testObject.books.get(0).getYearOfPublication(), is(2000));
        assertThat(testObject.books.get(1).getYearOfPublication(), is(2003));
        assertThat(testObject.books.get(0).getName(), is("scjp"));
        assertThat(testObject.books.get(1).getName(), is("Head First Java"));
    }

    @Test
    public void initializeOptionsTest() {
        assertThat(testObject.options.size(), is(2));
        assertThat(testObject.options.get(0), is("List Books"));
        assertThat(testObject.options.get(1), is("Quit"));
    }
}
