package com.lughtech.functionaInterfaces.function;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

    @Test
    void whenReturnFixedValue_thenReturnFixedValue() {
        //Suppliers have no parameters and return a values
        Supplier<String> fixedValue = () -> "fixedValue";

        assertEquals("fixedValue", fixedValue.get());
    }
}
