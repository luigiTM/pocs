package com.lughtech.mockito.stubbing;

import com.lughtech.mockito.support.Calculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThenAnswerTest {

    private List<String> stubbedList;
    private Calculator calculator;

    @Test
    void givenMock_whenThenAnswerIsUsed_thenShouldReturnDynamicValue() {
        stubbedList = mock(List.class);

        when(stubbedList.get(anyInt()))
                .thenAnswer(invocation -> {
                    Integer index = invocation.getArgument(0);
                    return "Value at index " + index;
                });

        assertEquals("Value at index 0", stubbedList.get(0));
        assertEquals("Value at index 1", stubbedList.get(1));
        assertEquals("Value at index 2", stubbedList.get(2));
    }

    @Test
    void givenMock_whenThenAnswerUsesSingleArgument_thenShouldReturnValueBasedOnArgument() {
        stubbedList = mock(List.class);

        when(stubbedList.get(anyInt()))
                .thenAnswer(invocation -> {
                    Integer index = invocation.getArgument(0);

                    if (index == 0) {
                        return "Zero";
                    }

                    if (index == 1) {
                        return "One";
                    }

                    if (index == 2) {
                        return "Two";
                    }

                    return "Unknown";
                });

        assertEquals("Zero", stubbedList.get(0));
        assertEquals("One", stubbedList.get(1));
        assertEquals("Two", stubbedList.get(2));
        assertEquals("Unknown", stubbedList.get(99));
    }

    @Test
    void givenMock_whenThenAnswerUsesMultipleArguments_thenShouldReturnValueBasedOnArguments() {
        calculator = mock(Calculator.class);

        when(calculator.sum(anyInt(), anyInt()))
                .thenAnswer(invocation -> {
                    Integer first = invocation.getArgument(0);
                    Integer second = invocation.getArgument(1);

                    return first + second;
                });

        assertEquals(3, calculator.sum(1, 2));
        assertEquals(10, calculator.sum(4, 6));
    }

    @Test
    void givenMock_whenThenAnswerUsesInvocationMethod_thenShouldAccessMethodMetadata() {
        stubbedList = mock(List.class);

        when(stubbedList.get(anyInt()))
                .thenAnswer(invocation ->
                        "Method called: " + invocation.getMethod().getName()
                );

        assertEquals("Method called: get", stubbedList.get(0));
    }

    @Test
    void givenMock_whenThenAnswerUsesInvocationMock_thenShouldAccessMockInstance() {
        stubbedList = mock(List.class);

        when(stubbedList.get(anyInt()))
                .thenAnswer(invocation ->
                        invocation.getMock().getClass().getSimpleName()
                );

        assertNotNull(stubbedList.get(0));
    }

    @Test
    void givenMock_whenThenAnswerThrowsException_thenShouldThrowExceptionConditionally() {
        stubbedList = mock(List.class);

        when(stubbedList.get(anyInt()))
                .thenAnswer(invocation -> {
                    Integer index = invocation.getArgument(0);

                    if (index < 0) {
                        throw new IllegalArgumentException("Negative index");
                    }

                    return "Valid";
                });

        assertEquals("Valid", stubbedList.get(1));

        assertThrows(
                IllegalArgumentException.class,
                () -> stubbedList.get(-1)
        );
    }

}
