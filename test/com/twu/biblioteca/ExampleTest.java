package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    BibliotecaApp testObject;

    @Before
    public void setUp() {
        testObject = new BibliotecaApp();
    }

    @Test
    public void getWelcomeMessageTest() {
        assertThat(testObject.getWelcomeMessage(), is("Welcome to Bibliotecs App!"));
    }
}
