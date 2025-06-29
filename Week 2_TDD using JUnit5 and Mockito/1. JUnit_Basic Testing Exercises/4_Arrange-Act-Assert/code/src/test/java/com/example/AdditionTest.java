package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdditionTest {

    int a;
    int b;

    @Before
    public void setUp() {
        a = 5;          // Arrange: initialize variables
        b = 3;
        System.out.println("Setting up values a = " + a + ", b = " + b);
    }

    @After
    public void tearDown() {       // Cleanup 
        System.out.println("Test finished\n");
    }

    @Test
    public void testAdditionPositive() {
        int result = a + b;     // Act      
        assertEquals(8, result);   // Assert
    }

    @Test
    public void testAdditionWithNegative() {       
        a = -2;  // Arrange
        b = 4;
       
        int result = a + b;  // Act
        
        assertEquals(2, result);   // Assert
    }

    @Test
    public void testAdditionZero() {
        
        a = 0;        // Arrange
        b = 0;
       
        int result = a + b;    // Act
        
        assertEquals(0, result);       // Assert
    }
}
