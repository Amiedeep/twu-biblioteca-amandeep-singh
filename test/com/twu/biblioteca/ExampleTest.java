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
    public void getBooksTest() {
        List<String> books = new ArrayList<String>();
        books.add("Head First Java");
        books.add("scjp");
        assertThat(testObject.getBooks(), is(books));
    }
}
