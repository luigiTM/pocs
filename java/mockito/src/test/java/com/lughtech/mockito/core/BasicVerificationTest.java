package com.lughtech.mockito.core;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

class BasicVerificationTest {
    
    private List<String> mockedList;

    @Test
    void givenMock_whenMethodCalled_thenVerifyInvocation() {
         mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList).add("One");
    }

    @Test
    void givenMock_whenMethodCalledMultipleTimes_thenVerifyInvocationCount() {
         mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("Two");

        verify(mockedList, times(2)).add("One");
        verify(mockedList, times(1)).add("Two");
    }

    @Test
    void givenMock_whenMethodNotCalled_thenVerifyNever() {
         mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList, never()).clear();
    }

    @Test
    void givenMock_whenMethodCalled_thenVerifyAtLeastAndAtMost() {
         mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atLeastOnce()).add("One");
        verify(mockedList, atLeast(1)).add("One");
        verify(mockedList, atMost(2)).add("One");
    }

    @Test
    void givenMock_whenMethodsCalled_thenVerifyOrderOfInvocations() {
         mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");
        mockedList.clear();

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("One");
        inOrder.verify(mockedList).add("Two");
        inOrder.verify(mockedList).clear();
    }

    @Test
    void givenMock_whenNoInteractionOccurs_thenVerifyNoInteractions() {
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
    void givenMock_whenOnlyOneMethodCalled_thenVerifyOnly() {
         mockedList = mock(List.class);

        mockedList.clear();

        verify(mockedList, only()).clear();
    }
}
