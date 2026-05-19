package com.lughtech.junit5.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assertions tests")
class AssertionsTest {

    @Test
    @DisplayName("Should validate basic assertions")
    void shouldValidateBasicAssertions() {
        String value = "JUnit 5";

        Assertions.assertEquals("JUnit 5", value);
        Assertions.assertNotEquals("Mockito", value);
        Assertions.assertTrue(value.startsWith("JUnit"));
        Assertions.assertFalse(value.isEmpty());
        Assertions.assertNotNull(value);
        Assertions.assertNull(null);
    }

    @Test
    @DisplayName("Should validate grouped assertions")
    void shouldValidateGroupedAssertions() {
        String name = "Luigi";
        int age = 33;

        Assertions.assertAll(
                () -> Assertions.assertEquals("Luigi", name),
                () -> Assertions.assertTrue(age > 18),
                () -> Assertions.assertNotNull(name)
        );
    }

    @Test
    @DisplayName("Should validate object reference")
    void shouldValidateObjectReference() {
        Object object = new Object();
        Object sameReference = object;

        Assertions.assertSame(object, sameReference);
    }
}
