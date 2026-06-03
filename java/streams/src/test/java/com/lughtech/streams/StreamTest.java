package com.lughtech.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {

    private final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Test
    void shouldReturnFalseWhenAllNumbersAreSmallerThanTen() {
        boolean allNumbersGreaterThanTen = numbers.stream().allMatch(number -> number > 10);

        assertFalse(allNumbersGreaterThanTen);
    }

    @Test
    void shouldReturnTrueWhenAllNumbersAreGreaterThanTwenty() {
        boolean allNumbersSmallerThanTwenty = numbers.stream().allMatch(number -> number < 20);

        assertTrue(allNumbersSmallerThanTwenty);
    }


    @Test
    void shouldReturnTrueWhenAnyNumberIsGreaterThanFive() {
        boolean anyNumberGreaterThenFive = numbers.stream().anyMatch(number -> number > 5);

        assertTrue(anyNumberGreaterThenFive);
    }

    @Test
    void shouldReturnFalseWhenAnyNumberIsGreaterThanEleven() {
        boolean anyNumberGreaterThenEleven = numbers.stream().anyMatch(number -> number > 11);

        assertFalse(anyNumberGreaterThenEleven);
    }

    @Test
    void shouldReturnTrueWhenNoNumbersAreLessThanZero() {
        boolean anyNumberGreaterThenEleven = numbers.stream().noneMatch(number -> number < 0);

        assertTrue(anyNumberGreaterThenEleven);
    }

    @Test
    void shouldReturnFalseWhenNoNumbersAreGreaterThanZero() {
        boolean anyNumberGreaterThenEleven = numbers.stream().noneMatch(number -> number > 0);

        assertFalse(anyNumberGreaterThenEleven);
    }

    @Test
    void shouldReturnSumWhenReducingNumbersWithSum() {
        Integer sum = numbers.stream().reduce(0, Integer::sum);

        assertEquals(55, sum);
    }

    @Test
    void shouldReturnTenWhenReducingNumbersWithMax() {
        Integer max = numbers.stream().reduce(0, Integer::max);

        assertEquals(10, max);
    }

    @Test
    void shouldReturnTenWhenCountingNumbers() {
        long count = numbers.stream().count();

        assertEquals(10, count);
    }

    @Test
    void shouldReturnFiveWhenCountingEvenNumbers() {
        long count = numbers.stream().filter(number -> number % 2 == 0 ).count();

        assertEquals(5, count);
    }

    @Test
    void shouldReturnMapWhenCollectingNumbersToMap() {
        Map<Integer, Integer> map = numbers.stream().collect(Collectors.toMap(Function.identity(), n -> n));

        assertEquals(10, map.size());
        assertEquals(1, map.get(1));
        assertEquals(2, map.get(2));
        assertEquals(3, map.get(3));
        assertEquals(4, map.get(4));
        assertEquals(5, map.get(5));
        assertEquals(6, map.get(6));
        assertEquals(7, map.get(7));
        assertEquals(8, map.get(8));
        assertEquals(9, map.get(9));
        assertEquals(10, map.get(10));
    }

    @Test
    void shouldReturnOneWhenFindingAnyNumber() {
        Optional<Integer> any = numbers.stream().findAny();

        assertFalse(any.isEmpty());
        assertEquals(1, any.get());
    }

    @Test
    void shouldReturnTwoWhenFindingAnyEvenNumber() {
        Optional<Integer> any = numbers.stream().filter(number -> number % 2 == 0).findAny();

        assertFalse(any.isEmpty());
        assertEquals(2, any.get());
    }

    @Test
    void shouldReturnOneWhenFindingFirstNumber() {
        Optional<Integer> any = numbers.stream().findFirst();

        assertFalse(any.isEmpty());
        assertEquals(1, any.get());
    }

    @Test
    void shouldReturnSixWhenFindingFirstNumberGreaterThanFive() {
        Optional<Integer> any = numbers.stream().filter(number -> number > 5).findFirst();

        assertFalse(any.isEmpty());
        assertEquals(6, any.get());
    }

    @Test
    void shouldReturnListWithOneAddedToEachElement() {
        List<Integer> mapped = numbers.stream().map(number -> number + 1).toList();

        assertFalse(mapped.isEmpty());
        assertEquals(2, mapped.get(0));
        assertEquals(3, mapped.get(1));
        assertEquals(4, mapped.get(2));
        assertEquals(5, mapped.get(3));
        assertEquals(6, mapped.get(4));
        assertEquals(7, mapped.get(5));
        assertEquals(8, mapped.get(6));
        assertEquals(9, mapped.get(7));
        assertEquals(10, mapped.get(8));
        assertEquals(11, mapped.get(9));
    }

}
