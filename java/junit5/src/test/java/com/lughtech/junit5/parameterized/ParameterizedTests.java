package com.lughtech.junit5.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@DisplayName("Parameterized tests")
class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(strings = {"JUnit", "Mockito", "Spring"})
    @DisplayName("Should validate non-empty strings")
    void shouldValidateNonEmptyStrings(String value) {
        Assertions.assertFalse(value.isBlank());
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 5, 15",
            "7, 8, 15"
    })
    @DisplayName("Should sum numbers correctly")
    void shouldSumNumbersCorrectly(int first, int second, int expected) {
        int result = first + second;

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("validEmails")
    @DisplayName("Should validate email format")
    void shouldValidateEmailFormat(String email) {
        Assertions.assertTrue(email.contains("@"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Should validate null or empty values")
    void shouldValidateNullOrEmptyValues(String value) {
        Assertions.assertTrue(value == null || value.isEmpty());
    }

    static Stream<String> validEmails() {
        return Stream.of(
                "test@email.com",
                "admin@email.com",
                "user@email.com"
        );
    }
}
