package com.lughtech.junit;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicTests {

    @TestFactory
    Stream<DynamicTest> evenNumberTests() {
        List<Integer> numbers = List.of(2, 4, 6, 8);
        return numbers.stream()
                .map(number ->
                        DynamicTest.dynamicTest(
                                "Should be even: " + number,
                                () -> assertEquals(0, number % 2)
                        )
                );
    }

}
