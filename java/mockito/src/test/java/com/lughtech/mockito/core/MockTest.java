package com.lughtech.mockito.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MockTest {

    private List<String> mockedList;

    @Test
    void givenList_whenAddAndClear_thenVerifyCalledMethods() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");
        mockedList.clear();

        verify(mockedList).add("One");
        verify(mockedList).add("Two");
        verify(mockedList).clear();
    }

    @Test
    void givenMock_whenMethodNotStubbed_thenReturnDefaultValues() {
        mockedList = mock(List.class);

        assertEquals(0, mockedList.size());
        assertFalse(mockedList.isEmpty());
        assertNull(mockedList.get(0));
    }

    @Test
    void givenMock_whenStubbed_thenReturnConfiguredValue() {
        mockedList = mock(List.class);

        when(mockedList.get(0)).thenReturn("One");

        assertEquals("One", mockedList.get(0));
        assertNull(mockedList.get(1));
    }

    @Test
    void givenMock_whenCalledMultipleTimes_thenVerifyInvocationCount() {
         mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("Two");

        verify(mockedList, times(2)).add("One");
        verify(mockedList, times(1)).add("Two");
        verify(mockedList, never()).add("Three");
    }

    @Test
    void givenMock_whenNoMethodCalled_thenVerifyNoInteractions() {
         mockedList = mock(List.class);

        verifyNoInteractions(mockedList);
    }

    @Test
    void givenMock_whenAllInteractionsVerified_thenVerifyNoMoreInteractions() {
         mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList).add("One");
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    void givenMock_whenMethodCalled_thenVerifyAtLeastAndAtMost() {
         mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atLeastOnce()).add("One");
        verify(mockedList, atLeast(2)).add("One");
        verify(mockedList, atMost(3)).add("One");
    }

    @Test
    void givenMock_whenReset_thenPreviousInteractionsAreRemoved() {
         mockedList = mock(List.class);

        mockedList.add("One");

        reset(mockedList);

        verifyNoInteractions(mockedList);
    }

    @Test
    void givenMock_whenClearInvocations_thenStubbingIsKeptButInteractionsAreRemoved() {
         mockedList = mock(List.class);

        when(mockedList.get(0)).thenReturn("One");

        mockedList.get(0);

        clearInvocations(mockedList);

        verifyNoInteractions(mockedList);
        assertEquals("One", mockedList.get(0));
    }
}