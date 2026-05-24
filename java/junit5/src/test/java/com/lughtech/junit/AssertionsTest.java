package com.lughtech.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Assertions Test")
public class AssertionsTest {

    @Test
    @DisplayName("Basic assertions")
    void shouldValidateBasicAssertions() {
        String value = "JUnit 5 POC";
        assertEquals("JUnit 5 POC", value);
        assertNotEquals("Mockito POC", value);
        assertTrue(value.startsWith("JUnit"));
        assertFalse(value.isEmpty());
        assertNotNull(value);
        assertNull(null);
    }

    @Test
    @DisplayName("Should validate grouped assertions")
    void shouldValidateGroupedAssertions() {
        String myName = "Luigi";
        int myAge = 33;

        assertAll(
                () -> assertEquals("Luigi", myName),
                () -> assertTrue(myAge > 18),
                () -> assertNotNull(myName)
        );
    }


    @Test
    @DisplayName("Should validate object reference")
    void shouldValidateObjectReference() {
        Object object = new Object();
        Object sameReference = object;

        assertSame(object, sameReference);
    }

    @Test
    @DisplayName("Should fail test")
    void shouldFail() {
        fail("This test should fail");
    }

}
