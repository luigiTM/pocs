package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerTest {

    @Test
    void givenListOfNames_thenPrintNames() {
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");

        //forEach receives a consumer
        names.forEach(name -> System.out.println("Hello, " + name));
    }

    @Test
    void givenListOfNamesAndAges_thenPrintNamesAndAges() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}
