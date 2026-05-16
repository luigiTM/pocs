package com.lughtech.mockito.stubbing;

import org.junit.jupiter.api.Test;

import java.util.List;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ThenReturnTest {

    private List<String> stubbedList;

    @Test
    void givenMock_whenMethodIsStubbed_thenShouldReturnConfiguredValue() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst()).thenReturn("Zero");

        assertEquals("Zero", stubbedList.getFirst());
    }

    @Test
    void givenMock_whenMethodIsStubbedWithMultipleValues_thenShouldReturnValuesInSequence() {
        stubbedList = mock(List.class);
        when(stubbedList.removeFirst()).thenReturn("Zero").thenReturn("One").thenReturn("Two");

        assertEquals("Zero", stubbedList.removeFirst());
        assertEquals("One", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
    }

    @Test
    void givenMock_whenMethodIsStubbedWithConsecutiveReturns_thenShouldKeepReturningLastValue() {
        stubbedList = mock(List.class);
        when(stubbedList.removeFirst()).thenReturn("Zero").thenReturn("One").thenReturn("Two");

        assertEquals("Zero", stubbedList.removeFirst());
        assertEquals("One", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
    }

    @Test
    void givenMock_whenDifferentArgumentsAreStubbed_thenShouldReturnSpecificValues() {
        stubbedList = mock(List.class);
        when(stubbedList.get(0)).thenReturn("Zero");
        when(stubbedList.get(1)).thenReturn("One");
        when(stubbedList.get(2)).thenReturn("Two");
        when(stubbedList.get(3)).thenReturn("Three");

        assertEquals("Zero", stubbedList.get(0));
        assertEquals("One", stubbedList.get(1));
        assertEquals("Two", stubbedList.get(2));
        assertEquals("Three", stubbedList.get(3));
    }

    @Test
    void givenMock_whenMethodIsNotStubbed_thenShouldReturnDefaultValue() {
        stubbedList = mock(List.class);

        assertNull(stubbedList.getFirst());
    }

    @Test
    void givenMock_whenStubbedMethodIsCalledMultipleTimes_thenShouldAlwaysReturnConfiguredValue() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst()).thenReturn("Zero");

        assertEquals("Zero", stubbedList.getFirst());
        assertEquals("Zero", stubbedList.getFirst());
        assertEquals("Zero", stubbedList.getFirst());
        assertEquals("Zero", stubbedList.getFirst());
        assertEquals("Zero", stubbedList.getFirst());
    }

    @Test
    void givenMock_whenMethodIsStubbedWithNull_thenShouldReturnNull() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst()).thenReturn(null);

        assertNull(stubbedList.getFirst());
    }

    @Test
    void givenMock_whenMethodIsStubbedUsingArgumentMatchers_thenShouldReturnConfiguredValue() {
        stubbedList = mock(List.class);
        when(stubbedList.get(anyInt())).thenReturn("It's a number");

        assertEquals("It's a number", stubbedList.get(0));
        assertEquals("It's a number", stubbedList.get(1));
        assertEquals("It's a number", stubbedList.get(2));
        assertEquals("It's a number", stubbedList.get(3));
    }

    @Test
    void givenMock_whenMethodIsRestubbed_thenLatestStubShouldOverridePreviousOne() {
        stubbedList = mock(List.class);
        when(stubbedList.get(anyInt())).thenReturn("It's a number");
        when(stubbedList.get(anyInt())).thenReturn("It's another number");

        assertEquals("It's another number", stubbedList.get(0));
        assertEquals("It's another number", stubbedList.get(1));
        assertEquals("It's another number", stubbedList.get(2));
        assertEquals("It's another number", stubbedList.get(3));
    }

    @Test
    void givenMock_whenThenReturnReceivesMultipleArguments_thenShouldReturnValuesSequentially() {
        stubbedList = mock(List.class);
        when(stubbedList.removeFirst()).thenReturn("Zero", "One", "Two");

        assertEquals("Zero", stubbedList.removeFirst());
        assertEquals("One", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
    }

    @Test
    void givenMock_whenStubbedMethodIsCalledBeyondConfiguredSequence_thenShouldReturnLastValueRepeatedly() {
        stubbedList = mock(List.class);
        when(stubbedList.removeFirst()).thenReturn("Zero", "One", "Two");

        assertEquals("Zero", stubbedList.removeFirst());
        assertEquals("One", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
        assertEquals("Two", stubbedList.removeFirst());
    }

    @Test
    void givenMock_whenCollectionMethodIsStubbed_thenShouldReturnConfiguredCollection() {
        stubbedList = mock(List.class);
        List<String> values = List.of("Zero", "One", "Two");

        when(stubbedList.reversed()).thenReturn(values);

        assertEquals(values, stubbedList.reversed());
        assertEquals("Zero", stubbedList.reversed().get(0));
        assertEquals("One", stubbedList.reversed().get(1));
        assertEquals("Two", stubbedList.reversed().get(2));
    }

    @Test
    void givenMock_whenOptionalMethodIsStubbed_thenShouldReturnConfiguredOptional() {
        Optional<String> optional = mock(Optional.class);

        when(optional.isPresent()).thenReturn(true);
        when(optional.get()).thenReturn("Zero");

        assertTrue(optional.isPresent());
        assertEquals("Zero", optional.get());
    }
}
