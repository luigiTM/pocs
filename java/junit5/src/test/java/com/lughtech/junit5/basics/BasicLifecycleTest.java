package com.lughtech.junit5.basics;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Basic lifecycle tests")
class BasicLifecycleTest {

    @BeforeAll
    void beforeAll() {
        System.out.println("Running before all tests");
    }

    @AfterAll
    void afterAll() {
        System.out.println("Running after all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Running before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Running after each test");
    }

    @Test
    @DisplayName("Should execute a basic test")
    void shouldExecuteBasicTest() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Should validate simple sum")
    void shouldValidateSimpleSum() {
        int result = 2 + 3;

        Assertions.assertEquals(5, result);
    }

    @Test
    @Disabled("Example of disabled test")
    @DisplayName("Should not execute disabled test")
    void shouldNotExecuteDisabledTest() {
        Assertions.fail("This test should not run");
    }
}
