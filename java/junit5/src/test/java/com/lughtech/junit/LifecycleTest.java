package com.lughtech.junit;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Lifecycle test")
public class LifecycleTest {

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
    @DisplayName("Basic test")
    void shouldExecuteBasicTest() {
        System.out.println("Basic test to show test execution");
    }

    @Test
    @DisplayName("Another basic test")
    void shouldExecuteAnotherBasicTest() {
        System.out.println("Another test to show test execution");
    }
}
