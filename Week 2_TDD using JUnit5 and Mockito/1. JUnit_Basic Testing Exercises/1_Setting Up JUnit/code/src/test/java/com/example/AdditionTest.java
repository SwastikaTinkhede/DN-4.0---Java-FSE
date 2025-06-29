package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdditionTest {

    @Test
    public void testAddPositiveNumbers() {
        Addition addition = new Addition();
        int result = addition.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAddWithZero() {
        Addition addition = new Addition();
        int result = addition.add(0, 7);
        assertEquals(7, result);
    }

    @Test
    public void testAddNegativeNumbers() {
        Addition addition = new Addition();
        int result = addition.add(-4, -1);
        assertEquals(-5, result);
    }
}
