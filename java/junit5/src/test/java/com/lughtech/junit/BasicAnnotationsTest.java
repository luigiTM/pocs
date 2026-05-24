package com.lughtech.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Basic Annotations Test")
public class BasicAnnotationsTest {

    @Test
    void shouldPrintThisIsATest() {
        System.out.println("This is a test");
    }

    @Test
    @DisplayName("Display name for a test")
    void shouldPrintThisIsATestWithADisplayName() {
        System.out.println("This is a test a test with a display name");
    }

    @Test
    @Tag("tagged-test")
    void shouldPrintThisTestHasATag() {
        System.out.println("This test has a tag");
    }

    @Test
    @DisplayName("Display name for a disabled test")
    @Disabled
    void shouldNotRunDisabledTest() {
        System.out.println("You should not be able to see this!");
    }
}
