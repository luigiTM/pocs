package com.lughtech.junit5.assumptions;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Assumptions tests")
class AssumptionTest {

    @Test
    @DisplayName("Should execute only on development environment")
    void shouldExecuteOnlyOnDevelopmentEnvironment() {
        String environment = System.getProperty("environment");

        assumeTrue("dev".equals(environment));

        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Should skip execution on production environment")
    void shouldSkipExecutionOnProductionEnvironment() {
        String environment = System.getProperty("environment");

        assumeFalse("prod".equals(environment));

        Assertions.assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("Should execute assertion conditionally")
    void shouldExecuteAssertionConditionally() {
        String javaVersion = System.getProperty("java.version");

        assumingThat(
                javaVersion.startsWith("21"),
                () -> Assertions.assertTrue(javaVersion.contains("21"))
        );

        Assertions.assertNotNull(javaVersion);
    }
}
