package com.lughtech.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturnZeroWhenZeroPlusZero() {
        var result = calculator.calculate("0+0");

        assertEquals(0, result);
    }

    @Test
    void shouldReturnTwoWhenOnePlusOne() {
        var result = calculator.calculate("1+1");

        assertEquals(2, result);
    }

    @Test
    void shouldReturnFourWhenTwoPlusTwo() {
        var result = calculator.calculate("2+2");

        assertEquals(4, result);
    }

    @Test
    void shouldReturnZeroWhenOneMinusOne() {
        var result = calculator.calculate("1-1");

        assertEquals(0, result);
    }

    @Test
    void shouldReturnTwoWhenThreeMinusOne() {
        var result = calculator.calculate("3-1");

        assertEquals(2, result);
    }

    @Test
    void shouldReturnFourWhenTwoTimesTwo() {
        var result = calculator.calculate("2*2");

        assertEquals(4, result);
    }

    @Test
    void shouldReturnTenWhenTwoTimesFive() {
        var result = calculator.calculate("2*5");

        assertEquals(10, result);
    }

    @Test
    void shouldReturnOneWhenTwoDividedByTwo() {
        var result = calculator.calculate("2/2");

        assertEquals(1, result);
    }

    @Test
    void shouldReturnFiveWhenFiveDividedByOne() {
        var result = calculator.calculate("5/1");

        assertEquals(5, result);
    }
}
