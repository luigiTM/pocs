package com.lughtech.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTests {

    @BeforeEach()
    void beforeEach() {
        System.out.println("Before each from parent class");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each from parent class");
    }

    @Nested
    class FirstNestedClass {

        @BeforeEach()
        void beforeEach() {
            System.out.println("Before each from first nested test class");
        }

        @Test
        void shouldExecuteFirstNestedTest() {
            System.out.println("This is a nested test");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each from parent class");
        }

    }

    @Nested
    class SecondNestedClass {

        @BeforeEach()
        void beforeEach() {
            System.out.println("Before each from second nested test class");
        }

        @Test
        void shouldExecuteSecondNestedTest() {
            System.out.println("This is another nested test");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each from parent class");
        }

    }
}
