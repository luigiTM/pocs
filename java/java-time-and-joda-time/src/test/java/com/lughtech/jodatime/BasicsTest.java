package com.lughtech.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BasicsTest {

    @Test
    void shouldCreateLocalDateWithCurrentDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    void shouldCreateLocalDateWithDefinedDate() {
        LocalDate firstOfJanuaryTwoThousand = LocalDate.parse("2000-01-01");

        assertEquals(2000, firstOfJanuaryTwoThousand.getYear());
        assertEquals(1, firstOfJanuaryTwoThousand.getMonthOfYear());
        assertEquals(1, firstOfJanuaryTwoThousand.getDayOfMonth());
    }

    @Test
    void shouldCreateDateTimeWithCurrentTime() {
        DateTime now = DateTime.now();
        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    void shouldCreateDateTimeWithDefinedTime() {
        DateTime firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");

        assertEquals(2000, firstOfJanuaryTwoThousandMidday.getYear());
        assertEquals(1, firstOfJanuaryTwoThousandMidday.getMonthOfYear());
        assertEquals(1, firstOfJanuaryTwoThousandMidday.getDayOfMonth());
        assertEquals(12, firstOfJanuaryTwoThousandMidday.getHourOfDay());
        assertEquals(0, firstOfJanuaryTwoThousandMidday.getMinuteOfHour());
        assertEquals(0, firstOfJanuaryTwoThousandMidday.getSecondOfMinute());
    }

    @Test
    void shouldCreateDateTimeWithDefaultTimezone() {
        DateTimeZone defaultDateTimeZone = DateTimeZone.forTimeZone(null);
        System.out.println(defaultDateTimeZone);

        assertNotNull(defaultDateTimeZone);
    }

    @Test
    void shouldCreateDateTimeZoneUTC() {
        DateTimeZone dateTimeZoneUTC = DateTimeZone.UTC;

        assertEquals("UTC", dateTimeZoneUTC.getID());
    }

    @Test
    void shouldCreateNewLocalDateWithoutChangingOrigin() {
        LocalDate firstOfJanuaryTwoThousand = LocalDate.parse("2000-01-01");
        LocalDate secondOfJanuaryTwoThousand = firstOfJanuaryTwoThousand.plusDays(1);

        assertEquals(1, firstOfJanuaryTwoThousand.getDayOfMonth());
        assertEquals(2, secondOfJanuaryTwoThousand.getDayOfMonth());
        assertEquals(secondOfJanuaryTwoThousand.getDayOfMonth(), firstOfJanuaryTwoThousand.getDayOfMonth() + 1);
    }

    @Test
    void shouldCreateNewLocalDateTimeWithoutChangingOrigin() {
        DateTime firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        DateTime firstOfJanuaryTwoThousandOneHour = firstOfJanuaryTwoThousandMidday.plusHours(1);

        assertEquals(12, firstOfJanuaryTwoThousandMidday.getHourOfDay());
        assertEquals(13, firstOfJanuaryTwoThousandOneHour.getHourOfDay());
        assertEquals(firstOfJanuaryTwoThousandOneHour.getHourOfDay(), firstOfJanuaryTwoThousandMidday.getHourOfDay() + 1);
    }
}
