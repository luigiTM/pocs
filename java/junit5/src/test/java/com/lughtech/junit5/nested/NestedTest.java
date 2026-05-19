package com.lughtech.junit5.nested;

import org.junit.jupiter.api.*;

@DisplayName("Nested tests")
class NestedTest {

    @Nested
    @DisplayName("When user is valid")
    class ValidUserTests {

        private String username;

        @BeforeEach
        void setUp() {
            username = "luigi";
        }

        @Test
        @DisplayName("Should create user successfully")
        void shouldCreateUserSuccessfully() {
            Assertions.assertNotNull(username);
            Assertions.assertFalse(username.isBlank());
        }

        @Test
        @DisplayName("Should validate username length")
        void shouldValidateUsernameLength() {
            Assertions.assertTrue(username.length() >= 3);
        }
    }

    @Nested
    @DisplayName("When user is invalid")
    class InvalidUserTests {

        private String username;

        @BeforeEach
        void setUp() {
            username = "";
        }

        @Test
        @DisplayName("Should identify invalid username")
        void shouldIdentifyInvalidUsername() {
            Assertions.assertTrue(username.isBlank());
        }
    }
}
