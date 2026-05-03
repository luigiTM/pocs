package com.lughtech.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ListStreamTest {

    private final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Test
    void givenListOfNumber_whenAllNumberSmallerThanTen_thenReturnFalse() {
        boolean allNumbersGreaterThanTen = numbers.stream().allMatch(number -> number > 10);

        assertFalse(allNumbersGreaterThanTen);
    }

    @Test
    void givenListOfNumber_whenAllNumberGreaterThanTwenty_thenReturnTrue() {
        boolean allNumbersSmallerThanTwenty = numbers.stream().allMatch(number -> number < 20);

        assertTrue(allNumbersSmallerThanTwenty);
    }

    @Test
    void givenListOfNumber_whenAnyNumberGreaterThenFive_thenReturnTrue() {
        boolean anyNumberGreaterThenFive = numbers.stream().anyMatch(number -> number > 5);

        assertTrue(anyNumberGreaterThenFive);
    }

    @Test
    void givenListOfNumber_whenAnyNumberGreaterThenEleven_thenReturnFalse() {
        boolean anyNumberGreaterThenEleven = numbers.stream().anyMatch(number -> number > 11);

        assertFalse(anyNumberGreaterThenEleven);
    }

    @Test
    void givenListOfNumber_whenNoneMatchLessThenZero_thenReturnTrue() {
        boolean anyNumberGreaterThenEleven = numbers.stream().noneMatch(number -> number < 0);

        assertTrue(anyNumberGreaterThenEleven);
    }

    @Test
    void givenListOfNumber_whenNoneMatchGreaterThenZero_thenReturnFalse() {
        boolean anyNumberGreaterThenEleven = numbers.stream().noneMatch(number -> number > 0);

        assertFalse(anyNumberGreaterThenEleven);
    }

    @Test
    void givenListOfNumber_whenReduceWithSum_thenReturnSum() {
        Integer sum = numbers.stream().reduce(0, Integer::sum);

        assertEquals(55, sum);
    }

    @Test
    void givenListOfNumber_whenReduceMax_thenReturnTen() {
        Integer max = numbers.stream().reduce(0, Integer::max);

        assertEquals(10, max);
    }

    @Test
    void givenListOfNumber_whenCount_thenReturnTen() {
        long count = numbers.stream().count();

        assertEquals(10, count);
    }

    @Test
    void givenListOfNumber_whenCountAfterFilterEvenNumbers_thenReturnFive() {
        long count = numbers.stream().filter(number -> number % 2 == 0 ).count();

        assertEquals(5, count);
    }

    @Test
    void givenListOfNumber_whenCollectToMap_thenReturnMap() {
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
    void givenListOfNumber_whenFindAny_thenReturnOne() {
        Optional<Integer> any = numbers.stream().findAny();

        assertFalse(any.isEmpty());
        assertEquals(1, any.get());
    }

    @Test
    void givenListOfNumber_whenFindAnyFilteringEvenNumber_thenReturnTwo() {
        Optional<Integer> any = numbers.stream().filter(number -> number % 2 == 0).findAny();

        assertFalse(any.isEmpty());
        assertEquals(2, any.get());
    }
}
