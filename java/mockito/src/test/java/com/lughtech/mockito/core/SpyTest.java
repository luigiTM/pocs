package com.lughtech.mockito.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpyTest {

    @Test
    void givenSpy_whenRealMethodIsCalled_thenShouldExecuteRealBehavior() {
        List<String> list = new ArrayList<>();
        List<String> spyList = spy(list);

        spyList.add("One");
        spyList.add("Two");

        assertEquals(2, spyList.size());
        assertEquals("One", spyList.get(0));

        verify(spyList).add("One");
        verify(spyList).add("Two");
    }

    @Test
    void givenSpy_whenMethodIsStubbed_thenShouldReturnStubbedValue() {
        List<String> spyList = spy(new ArrayList<>());

        doReturn("Mocked").when(spyList).get(0);

        assertEquals("Mocked", spyList.get(0));
    }

    @Test
    void givenSpy_whenUsingWhenThenReturnOnRealMethod_thenShouldCallRealMethodDuringStubbing() {
        List<String> spyList = spy(new ArrayList<>());

        assertThrows(IndexOutOfBoundsException.class, () ->
                when(spyList.get(0)).thenReturn("Mocked")
        );
    }

    @Test
    void givenSpy_whenUsingDoReturn_thenShouldNotCallRealMethodDuringStubbing() {
        List<String> spyList = spy(new ArrayList<>());

        doReturn("Mocked").when(spyList).get(0);

        assertEquals("Mocked", spyList.get(0));
    }

    @Test
    void givenSpy_whenRealAndStubbedMethodsAreMixed_thenShouldUseBothBehaviors() {
        List<String> spyList = spy(new ArrayList<>());

        spyList.add("One");

        doReturn(100).when(spyList).size();

        assertEquals("One", spyList.get(0));
        assertEquals(100, spyList.size());

        verify(spyList).add("One");
        verify(spyList).get(0);
        verify(spyList).size();
    }

    @Test
    void givenSpy_whenVoidMethodIsStubbed_thenShouldNotExecuteRealMethod() {
        List<String> spyList = spy(new ArrayList<>());

        doNothing().when(spyList).clear();

        spyList.add("One");
        spyList.clear();

        assertEquals(1, spyList.size());

        verify(spyList).clear();
    }

    @Test
    void givenSpy_whenVoidMethodThrowsException_thenShouldThrowConfiguredException() {
        List<String> spyList = spy(new ArrayList<>());

        doThrow(new IllegalStateException("Cannot clear list"))
                .when(spyList)
                .clear();

        assertThrows(IllegalStateException.class, spyList::clear);
    }

    @Test
    void givenSpy_whenReset_thenShouldRemoveStubbingAndInteractions() {
        List<String> spyList = spy(new ArrayList<>());

        doReturn(100).when(spyList).size();

        assertEquals(100, spyList.size());

        reset(spyList);

        assertEquals(0, spyList.size());
        verify(spyList).size();
    }
}
