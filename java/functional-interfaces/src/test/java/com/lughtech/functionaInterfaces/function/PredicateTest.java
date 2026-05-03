package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class PredicateTest {

    @Test
    void givenName_whenStartsWithLetterA_thenReturnTrue() {
        Predicate<String> startWithLetterA = text -> text.toLowerCase().startsWith("a");

        assertTrue(startWithLetterA.test("Angela"));
        assertTrue(startWithLetterA.test("Aaron"));
        assertFalse(startWithLetterA.test("Bob"));
        assertFalse(startWithLetterA.test("Claire"));
        assertFalse(startWithLetterA.test("David"));
    }
}
