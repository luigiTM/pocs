package com.lughtech.mockito.verification;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.VerificationInOrderFailure;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InOrderVerificationTest {

    private List<String> mockedList;
    private List<String> secondMockedList;

    @Test
    void givenMock_whenMethodsAreCalledInOrder_thenShouldVerifyInvocationOrder() {
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
    void givenMock_whenMethodsAreCalledOutOfOrder_thenShouldThrowVerificationInOrderFailure() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");

        InOrder inOrder = inOrder(mockedList);

        assertThrows(
                VerificationInOrderFailure.class,
                () -> {
                    inOrder.verify(mockedList).add("Two");
                    inOrder.verify(mockedList).add("One");
                }
        );
    }

    @Test
    void givenMultipleMocks_whenMethodsAreCalledInOrder_thenShouldVerifyAcrossMocks() {
        mockedList = mock(List.class);
        secondMockedList = mock(List.class);

        mockedList.add("One");
        secondMockedList.add("Two");
        mockedList.clear();

        InOrder inOrder = inOrder(mockedList, secondMockedList);

        inOrder.verify(mockedList).add("One");
        inOrder.verify(secondMockedList).add("Two");
        inOrder.verify(mockedList).clear();
    }

    @Test
    void givenMultipleMocks_whenMethodsAreCalledOutOfOrder_thenShouldFailVerification() {
        mockedList = mock(List.class);
        secondMockedList = mock(List.class);

        mockedList.add("One");
        secondMockedList.add("Two");

        InOrder inOrder = inOrder(mockedList, secondMockedList);

        assertThrows(
                VerificationInOrderFailure.class,
                () -> {
                    inOrder.verify(secondMockedList).add("Two");
                    inOrder.verify(mockedList).add("One");
                }
        );
    }

    @Test
    void givenMock_whenMethodIsVerifiedWithTimes_thenShouldVerifyInvocationCountInOrder() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("One");
        mockedList.add("Two");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList, times(2)).add("One");
        inOrder.verify(mockedList).add("Two");
    }

    @Test
    void givenMock_whenOnlyPartialInteractionsAreVerified_thenShouldAllowRemainingInteractions() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");
        mockedList.clear();

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("One");
    }

    @Test
    void givenMock_whenAllInteractionsAreVerifiedInOrder_thenShouldVerifyNoMoreInteractions() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("One");
        inOrder.verify(mockedList).add("Two");

        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void givenMock_whenUnexpectedInteractionExists_thenShouldFailNoMoreInteractionsVerification() {
        mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add("Two");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("One");

        assertThrows(
                VerificationInOrderFailure.class,
                inOrder::verifyNoMoreInteractions
        );
    }

    @Test
    void givenMock_whenMethodIsNeverCalled_thenShouldVerifyNeverInOrder() {
        mockedList = mock(List.class);

        mockedList.add("One");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("One");
        inOrder.verify(mockedList, never()).add("Two");
    }

}
