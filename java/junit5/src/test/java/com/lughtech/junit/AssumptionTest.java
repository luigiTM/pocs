package com.lughtech.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest {

    private boolean shouldExecute;

    @Test
    void shouldExecuteTestBasedOnAssumption() {
        shouldExecute = true;
        assumeTrue(shouldExecute);
        System.out.println("This test should execute");
    }

    @Test
    void shouldNotExecuteTestBasedOnAssumption() {
        shouldExecute = false;
        assumeTrue(shouldExecute);
        System.out.println("This test should NOT execute");
    }

    @Test
    void shouldExecuteTestBasedOnAssumptionUsingLambda() {
        shouldExecute = true;
        assumingThat(
                shouldExecute,
                () -> assertEquals(2 + 2, 4)
        );
    }
}
