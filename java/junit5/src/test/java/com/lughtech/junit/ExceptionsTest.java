package com.lughtech.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Exceptions Test")
public class ExceptionsTest {

    @Test
    @DisplayName("Should throw exception")
    void shouldThrowExceptionTest() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> divide(10, 0)
        );

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Should not throw exception")
    void shouldNotThrowExceptionTest() {
        Assertions.assertDoesNotThrow(() -> divide(10, 2));
    }

    private int divide(int a, int b) {
        return a/b;
    }

}
