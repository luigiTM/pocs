package com.lughtech.mockito.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockTest {

    @Test
    void givenList_whenAddAndClear_thenVerifyCalledMethods() {
        List mockedList = mock(List.class);

        mockedList.add("One");
        mockedList.add(1);
        mockedList.clear();

        verify(mockedList).add("One");
        verify(mockedList).add(1);
        verify(mockedList).clear();
    }
}
