package com.lughtech.mockito.verification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class TimesVerificationTest  {

    private List<String> mockedList;

    @Test
    void givenMock_whenMethodIsCalledOnce_thenShouldVerifyOneInvocation() {
        mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList, times(1)).add("One");
    }

    @Test
    void givenMock_whenMethodIsCalledMultipleTimes_thenShouldVerifyExactInvocationCount() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, times(3)).add("One");
    }

    @Test
    void givenMock_whenMethodIsNeverCalled_thenShouldVerifyZeroInvocations() {
        mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList, never()).add("Two");
    }

    @Test
    void givenMock_whenMethodIsCalledAtLeastOnce_thenShouldVerifyAtLeastOnce() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atLeastOnce()).add("One");
    }

    @Test
    void givenMock_whenMethodIsCalledAtLeastSpecificTimes_thenShouldVerifyMinimumInvocations() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atLeast(2)).add("One");
    }

    @Test
    void givenMock_whenMethodIsCalledAtMostSpecificTimes_thenShouldVerifyMaximumInvocations() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atMost(3)).add("One");
    }

    @Test
    void givenMock_whenMethodIsCalledBetweenMinAndMax_thenShouldVerifyAtLeastAndAtMost() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("One");

        verify(mockedList, atLeast(2)).add("One");
        verify(mockedList, atMost(4)).add("One");
    }

    @Test
    void givenMock_whenDifferentArgumentsAreUsed_thenShouldVerifyInvocationCountPerArgument() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("Two");

        verify(mockedList, times(2)).add("One");
        verify(mockedList, times(1)).add("Two");
    }

    @Test
    void givenMock_whenDifferentMethodsAreCalled_thenShouldVerifyInvocationCountPerMethod() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");
        mockedList.clear();

        verify(mockedList, times(2)).add(anyString());
        verify(mockedList, times(1)).clear();
    }

    @Test
    void givenMock_whenTimesZeroIsUsed_thenShouldBehaveLikeNever() {
        mockedList = mock(List.class);

        mockedList.add("One");

        verify(mockedList, times(0)).add("Two");
        verify(mockedList, never()).add("Two");
    }

    @Test
    void givenMock_whenOnlyOneInteractionIsExpected_thenShouldVerifyOnlyInvocation() {
        mockedList = mock(List.class);

        mockedList.clear();

        verify(mockedList, only()).clear();
    }

    @Test
    void givenMock_whenNoMoreInteractionsAreExpected_thenShouldVerifyNoMoreInteractions() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.clear();

        verify(mockedList).add("One");
        verify(mockedList).clear();
        verifyNoMoreInteractions(mockedList);
    }
}
