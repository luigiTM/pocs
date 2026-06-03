package com.lughtech.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTests {

    private Random random = new Random();

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test ---");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After Each Test ###");
    }

    @RepeatedTest(value = 10, failureThreshold = 2)
    void shouldGenerateRandomNumberWithinRange() {
        int number = random.nextInt(10);
        System.out.println("Asserting number " + number);
        assertTrue(number < 8);
    }

    @RepeatedTest(3)
    void shouldExposeRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());

        assertEquals(3, repetitionInfo.getTotalRepetitions());
    }

}
