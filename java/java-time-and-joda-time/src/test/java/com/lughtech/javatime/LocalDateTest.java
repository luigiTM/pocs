package com.lughtech.javatime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocalDateTest {

    @Test
    void shouldCreateLocalDateWithCurrentDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        assertNotNull(localDate);
    }

    @Test
    void shouldCreateLocalDateWithDefinedDate() {
        LocalDate firstOfJanuaryTwoThousand = LocalDate.of(2000,1, 1);

        assertEquals(2000, firstOfJanuaryTwoThousand.getYear());
        assertEquals(1, firstOfJanuaryTwoThousand.getMonth().getValue());
        assertEquals(1, firstOfJanuaryTwoThousand.getDayOfMonth());
    }

}
