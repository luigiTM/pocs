package com.lughtech.mockito.advanced;

import com.lughtech.helpers.StaticUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticMockTest {

    @Test
    void shouldVerifyStaticMockNameReturn() {
        assertEquals("Luigi", StaticUtils.name());

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(StaticUtils::name).thenReturn("Mario");
            assertEquals("Mario", StaticUtils.name());
        }

        assertEquals("Luigi", StaticUtils.name());
    }

    @Test
    void shouldVerifyStaticMockRangeReturn() {
        assertEquals(Arrays.asList(2, 3, 4, 5), StaticUtils.range(2, 6));

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(() -> StaticUtils.range(2, 6))
                    .thenReturn(Arrays.asList(10, 11, 12));

            assertEquals(Arrays.asList(10, 11, 12), StaticUtils.range(2, 6));
        }

        assertEquals(Arrays.asList(2, 3, 4, 5), StaticUtils.range(2, 6));
    }
}
