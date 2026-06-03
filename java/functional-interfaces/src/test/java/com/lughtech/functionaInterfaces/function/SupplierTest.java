package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

    @Test
    void shouldReturnFixedValue() {
        //Suppliers have no parameters and return a value
        Supplier<String> fixedValue = () -> "fixedValue";

        assertEquals("fixedValue", fixedValue.get());
    }
}
