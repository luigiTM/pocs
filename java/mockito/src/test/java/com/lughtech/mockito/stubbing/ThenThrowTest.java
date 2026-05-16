package com.lughtech.mockito.stubbing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ThenThrowTest {

    private List<String> stubbedList;

    @Test
    void givenMock_whenMethodIsStubbedToThrowException_thenShouldThrowConfiguredException() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst()).thenThrow(new IllegalStateException("List is invalid"));

        assertThrows(IllegalStateException.class, () -> stubbedList.getFirst());
    }

    @Test
    void givenMock_whenVoidMethodIsStubbedToThrowException_thenShouldThrowConfiguredException() {
        stubbedList = mock(List.class);
        doThrow(new IllegalStateException("Cannot clear list"))
                .when(stubbedList)
                .clear();

        assertThrows(IllegalStateException.class, () -> stubbedList.clear());
    }

    @Test
    void givenMock_whenMethodIsStubbedWithSpecificArgument_thenShouldThrowExceptionOnlyForThatArgument() {
        stubbedList = mock(List.class);
        when(stubbedList.get(0)).thenThrow(new IllegalStateException("Invalid index"));

        assertThrows(IllegalStateException.class, () -> stubbedList.get(0));
        assertNull(stubbedList.get(1));
    }

    @Test
    void givenMock_whenMethodIsStubbedWithArgumentMatcher_thenShouldThrowExceptionForMatchingArguments() {
        stubbedList = mock(List.class);
        when(stubbedList.get(anyInt())).thenThrow(new IllegalStateException("Invalid index"));

        assertThrows(IllegalStateException.class, () -> stubbedList.get(0));
        assertThrows(IllegalStateException.class, () -> stubbedList.get(1));
        assertThrows(IllegalStateException.class, () -> stubbedList.get(2));
    }

    @Test
    void givenMock_whenMethodIsStubbedWithMultipleExceptions_thenShouldThrowExceptionsInSequence() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst())
                .thenThrow(new IllegalStateException("First failure"))
                .thenThrow(new IllegalArgumentException("Second failure"))
                .thenThrow(new RuntimeException("Third failure"));

        assertThrows(IllegalStateException.class, () -> stubbedList.getFirst());
        assertThrows(IllegalArgumentException.class, () -> stubbedList.getFirst());
        assertThrows(RuntimeException.class, () -> stubbedList.getFirst());
    }

    @Test
    void givenMock_whenExceptionSequenceEnds_thenShouldKeepThrowingLastException() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst())
                .thenThrow(new IllegalStateException("First failure"))
                .thenThrow(new IllegalArgumentException("Last failure"));

        assertThrows(IllegalStateException.class, () -> stubbedList.getFirst());
        assertThrows(IllegalArgumentException.class, () -> stubbedList.getFirst());
        assertThrows(IllegalArgumentException.class, () -> stubbedList.getFirst());
        assertThrows(IllegalArgumentException.class, () -> stubbedList.getFirst());
    }

    @Test
    void givenMock_whenMethodIsRestubbed_thenLatestExceptionStubShouldOverridePreviousOne() {
        stubbedList = mock(List.class);
        when(stubbedList.getFirst())
                .thenThrow(new IllegalStateException("First failure"));
        doThrow(new IllegalArgumentException("Second failure"))
                .when(stubbedList)
                .getFirst();

        assertThrows(IllegalArgumentException.class, () -> stubbedList.getFirst());
    }

}
