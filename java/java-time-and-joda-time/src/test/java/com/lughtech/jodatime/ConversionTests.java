package com.lughtech.jodatime;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionTests {

    @Test
    void shouldConvertDateToDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 12, 0, 0);

        Date date = calendar.getTime();

        var dateTime = new DateTime(date);

        assertEquals(1, dateTime.getDayOfMonth());
        assertEquals(1, dateTime.getMonthOfYear());
        assertEquals(2000, dateTime.getYear());
        assertEquals(12, dateTime.getHourOfDay());
        assertEquals(0, dateTime.getMinuteOfHour());
        assertEquals(0, dateTime.getSecondOfMinute());
    }

}
