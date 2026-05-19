package com.lughtech.junit5.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Exception handling tests")
class ExceptionHandlingTest {

    @Test
    @DisplayName("Should throw arithmetic exception")
    void shouldThrowArithmeticException() {
        ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> divide(10, 0)
        );

        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Should not throw exception")
    void shouldNotThrowException() {
        Assertions.assertDoesNotThrow(() -> divide(10, 2));
    }

    private int divide(int first, int second) {
        return first / second;
    }
}
