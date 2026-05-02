package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {

    @Test
    void givenListOfNames_thenPrintNames() {
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");

        //forEach receives a consumer
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
