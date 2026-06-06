package com.lughtech.javatime;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionTest {

    @Test
    void shouldConvertDateToLocalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date date = calendar.getTime();

        var localDate = LocalDate.fromDateFields(date);

        assertEquals(1, localDate.getDayOfMonth());
        assertEquals(1, localDate.getMonthOfYear());
        assertEquals(2000, localDate.getYear());
    }

    @Test
    void shouldConvertDateToLocalDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 12, 0, 0);
        Date date = calendar.getTime();

        var localDateTime = LocalDateTime.fromDateFields(date);

        assertEquals(1, localDateTime.getDayOfMonth());
        assertEquals(1, localDateTime.getMonthOfYear());
        assertEquals(2000, localDateTime.getYear());
        assertEquals(12, localDateTime.getHourOfDay());
        assertEquals(0, localDateTime.getMinuteOfHour());
        assertEquals(0, localDateTime.getSecondOfMinute());
    }
}
