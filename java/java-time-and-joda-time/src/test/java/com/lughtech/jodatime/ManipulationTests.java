package com.lughtech.jodatime;

import org.junit.jupiter.api.Test;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManipulationTests {

    @Test
    void shouldAddOneDayToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.parse("2000-01-01");
        var secondOfJanuaryTwoThousand = firstOfJanuaryTwoThousand.plusDays(1);

        assertEquals(2, secondOfJanuaryTwoThousand.getDayOfMonth());
    }

    @Test
    void shouldAddOneMonthToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.parse("2000-01-01");
        var firstOfFebruaryTwoThousand = firstOfJanuaryTwoThousand.plusMonths(1);

        assertEquals(2, firstOfFebruaryTwoThousand.getMonthOfYear());
    }

    @Test
    void shouldAddOneYearToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.parse("2000-01-01");
        var firstOfJanuaryTwoThousandAndOne = firstOfJanuaryTwoThousand.plusYears(1);

        assertEquals(2001, firstOfJanuaryTwoThousandAndOne.getYear());
    }

    @Test
    void shouldAddOneDayToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var secondOfJanuaryTwoThousandMidday = firstOfJanuaryTwoThousandMidday.plusDays(1);

        assertEquals(2, secondOfJanuaryTwoThousandMidday.getDayOfMonth());
    }

    @Test
    void shouldAddOneMonthToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfFebruaryTwoThousandMidday = firstOfJanuaryTwoThousandMidday.plusMonths(1);

        assertEquals(2, firstOfFebruaryTwoThousandMidday.getMonthOfYear());
    }

    @Test
    void shouldAddOneYearToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandAndOneMidday = firstOfJanuaryTwoThousandMidday.plusYears(1);

        assertEquals(2001, firstOfJanuaryTwoThousandAndOneMidday.getYear());
    }

    @Test
    void shouldAddOneHourToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandOneHour = firstOfJanuaryTwoThousandMidday.plusHours(1);

        assertEquals(13, firstOfJanuaryTwoThousandOneHour.getHourOfDay());
    }

    @Test
    void shouldAddOneMinuteToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandMiddayAndOneMinute = firstOfJanuaryTwoThousandMidday.plusMinutes(1);

        assertEquals(1, firstOfJanuaryTwoThousandMiddayAndOneMinute.getMinuteOfHour());
    }

    @Test
    void shouldAddOneSecondToDateTime() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandMiddayAndOneSecond = firstOfJanuaryTwoThousandMidday.plusSeconds(1);

        assertEquals(1, firstOfJanuaryTwoThousandMiddayAndOneSecond.getSecondOfMinute());
    }
}
