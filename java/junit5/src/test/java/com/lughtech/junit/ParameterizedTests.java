package com.lughtech.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {

    static List<String> cities = Arrays.asList("Madrid", "Rome", "Paris", "London");

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void shouldReturnTrueIfNumberIsOdd(Integer number) {
        assertTrue(isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void shouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @NullSource
    void shouldReturnTrueForNullInputs(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @EmptySource
    void shouldReturnTrueForEmptyStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void shouldReturnTrueForAllTypesOfBlankStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void shouldReturnTrueIfMonthIsBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void shouldReturnTrueIfMonthIs30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EnumSource.Mode.EXCLUDE)
    void shouldReturnTrueIfMonthIs31DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(31, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void shouldReturnTrueIfFourMonthsEndWithBer(Month month) {
        EnumSet<Month> months =
                EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertTrue(months.contains(month));
    }

    @ParameterizedTest
    @CsvSource({
            "test,TEST",
            "tEst,TEST",
            "Java,JAVA"
    })
    void shouldGenerateTheExpectedValueUpperCase(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "test:test",
                    "tEst:test",
                    "Java:java"
            },
            delimiter = ':')
    void shouldGenerateTheExpectedValueLowerCase(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_input.csv", numLinesToSkip = 1)
    void shouldGenerateTheExpectedValueUpperCaseForCsvFile(
            String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void shouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, isBlank(input));
    }

    @ParameterizedTest
    @FieldSource("cities")
    void shouldReturnFalseWhenTheArgHasAtLeastOneCharacter(String arg) {
        assertFalse(isBlank(arg));
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private boolean isOdd(Integer number) {
        return number % 2 != 0;
    }
}
