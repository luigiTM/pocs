package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    @Test
    void shouldReturnTWhenReturningFirstLetterFromText() {
        Function<String, Character> returnFirstLetter = s -> s.charAt(0);

        assertEquals('T', returnFirstLetter.apply("Text"));
    }

    @Test
    void shouldReturnStringOneWhenConvertingIntOneToString() {
        IntFunction<String> convertIntToString = String::valueOf;

        assertEquals("1", convertIntToString.apply(1));
    }

    @Test
    void shouldReturnStringOneWhenConvertingLongOneToString() {
        LongFunction<String> convertLongToString = String::valueOf;

        assertEquals("1", convertLongToString.apply(1L));
    }

    @Test
    void shouldReturnStringOneWhenConvertingDoubleOneToString() {
        DoubleFunction<String> convertDoubleToString = String::valueOf;

        assertEquals("1.0", convertDoubleToString.apply(1D));
    }

    @Test
    void shouldReturnOneWhenConvertingStringOneToInt() {
        ToIntFunction<String> convertStringToIn = Integer::valueOf;

        assertEquals(1, convertStringToIn.applyAsInt("1"));
    }

    @Test
    void shouldReturnOneWhenConvertingStringOneToLong() {
        ToLongFunction<String> convertStringToLong = Long::valueOf;

        assertEquals(1L, convertStringToLong.applyAsLong("1"));
    }

    @Test
    void shouldReturnOneWhenConvertingStringOneToDouble() {
        ToDoubleFunction<String> convertStringToDouble = Double::valueOf;

        assertEquals(1D, convertStringToDouble.applyAsDouble("1"));
    }

    // There are also DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction,
    // IntToLongFunction, LongToIntFunction, LongToDoubleFunction

    @Test
    void shouldReturnConcatenatedTextWhenConcatenatingText() {
        BiFunction<String, String, String> concatenateText = (s1, s2) -> s1 + " " +s2;

        assertEquals("Concatenated Text", concatenateText.apply("Concatenated", "Text"));
    }

    // There are also ToDoubleBiFunction, ToIntBiFunction, and ToLongBiFunction to return primitive types.
}
