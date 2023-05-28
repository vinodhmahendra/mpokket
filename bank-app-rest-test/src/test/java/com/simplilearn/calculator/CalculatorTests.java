package com.simplilearn.calculator;

import com.simplilearn.model.Calculator;
import org.junit.jupiter.api.*;

import static  org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
public class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        System.out.println("Setting up a new Calculator for each test");
        calculator = new Calculator();
    }
    @BeforeAll
    static void setupAll(){
        System.out.println("This is executed once before all tests.");
    }
    @DisplayName("Simple addition should work")
    @Test
    void testAdd(){
        assertEquals(5,calculator.add(2,3));
    }


    @Tag("slow")
    @DisplayName("Another test with a different tag")
    @Test
    void testAnotherAdd() {
        assertEquals(9, calculator.add(4, 5));
    }

    @Disabled
    @Test
    void testDisabled(){
        assertEquals(10,calculator.add(5,5));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after each test");
    }

    @AfterAll
    static  void tearDownAll(){
        System.out.println("This is executed once after all tests");
    }

}
