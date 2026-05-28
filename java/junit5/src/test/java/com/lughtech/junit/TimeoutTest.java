package com.lughtech.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Timeout(5)
public class TimeoutTest {

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void shouldFailAfterOneSecond() throws InterruptedException {
        Thread.sleep(10_000);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.MINUTES, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void shouldUseADifferentThread() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10_000);
    }

    @Test
    void shouldFailAfterFiveSecond() throws InterruptedException {
        Thread.sleep(10_000);
    }

    @Test
    void shouldNotFail() throws InterruptedException {
        Thread.sleep(2_000);
        System.out.println("I have not failed!");
    }

    @Test
    void shouldFailAfterTwoSecondsUsingAssertTimeout() {
        assertTimeout(ofSeconds(2), () -> {
            Thread.sleep(10_000);
        });
    }

    @Test
    void shouldFailAfterTwoSecondsUsingAssertTimeoutPreemptively() {
        assertTimeoutPreemptively(ofSeconds(2), () -> {
            Thread.sleep(10_000);
        });
    }

}
