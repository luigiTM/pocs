package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

    @Test
    void shouldReturnTextWhenConvertingTextToUpperCase() {
        UnaryOperator<String> toUpperCase = String::toUpperCase;

        assertEquals("TEXT", toUpperCase.apply("text"));
    }

    @Test
    void shouldReturnSumWhenSummingAllNumbers() {
        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        BinaryOperator<Integer> sumAll = Integer::sum;

        //Reduce receives a binary operator
        assertEquals(37, values.stream().reduce(0, sumAll));
    }

}
