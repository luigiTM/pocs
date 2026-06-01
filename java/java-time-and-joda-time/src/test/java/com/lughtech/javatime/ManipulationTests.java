package com.lughtech.javatime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManipulationTests {

    @Test
    void shouldAddOneDayToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var secondOfJanuaryTwoThousand = firstOfJanuaryTwoThousand.plusDays(1);

        assertEquals(2, secondOfJanuaryTwoThousand.getDayOfMonth());
    }

    @Test
    void shouldAddOneMonthToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var firstOfFebruaryTwoThousand = firstOfJanuaryTwoThousand.plusMonths(1);

        assertEquals(2, firstOfFebruaryTwoThousand.getMonth().getValue());
    }

    @Test
    void shouldAddOneYearToLocalDate() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var firstOfJanuaryTwoThousandAndOne = firstOfJanuaryTwoThousand.plusYears(1);

        assertEquals(2001, firstOfJanuaryTwoThousandAndOne.getYear());
    }

    @Test
    void shouldAddOneHourToLocalTime() {
        var midday = LocalTime.of(12, 0, 0);
        var oneHour = midday.plusHours(1);

        assertEquals(13, oneHour.getHour());
    }

    @Test
    void shouldAddOneMinuteToLocalTime() {
        var midday = LocalTime.of(12, 0, 0);
        var middayAndOneMinute = midday.plusMinutes(1);

        assertEquals(1, middayAndOneMinute.getMinute());
    }

    @Test
    void shouldAddOneSecondToLocalTime() {
        var midday = LocalTime.of(12, 0, 0);
        var middayAndOneSecond = midday.plusSeconds(1);

        assertEquals(1, middayAndOneSecond.getSecond());
    }

    @Test
    void shouldAddOneDayToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var secondOfJanuaryTwoThousandMidday = firstOfJanuaryTwoThousandMidday.plusDays(1);

        assertEquals(2, secondOfJanuaryTwoThousandMidday.getDayOfMonth());
    }

    @Test
    void shouldAddOneMonthToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var firstOfFebruaryTwoThousandMidday = firstOfJanuaryTwoThousandMidday.plusMonths(1);

        assertEquals(2, firstOfFebruaryTwoThousandMidday.getMonth().getValue());
    }

    @Test
    void shouldAddOneYearToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var firstOfJanuaryTwoThousandAndOneMidday = firstOfJanuaryTwoThousandMidday.plusYears(1);

        assertEquals(2001, firstOfJanuaryTwoThousandAndOneMidday.getYear());
    }

    @Test
    void shouldAddOneHourToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var firstOfJanuaryTwoThousandOneHour = firstOfJanuaryTwoThousandMidday.plusHours(1);

        assertEquals(13, firstOfJanuaryTwoThousandOneHour.getHour());
    }

    @Test
    void shouldAddOneMinuteToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var firstOfJanuaryTwoThousandMiddayAndOneMinute = firstOfJanuaryTwoThousandMidday.plusMinutes(1);

        assertEquals(1, firstOfJanuaryTwoThousandMiddayAndOneMinute.getMinute());
    }

    @Test
    void shouldAddOneSecondToLocalDateTime() {
        var firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        var firstOfJanuaryTwoThousandMiddayAndOneSecond = firstOfJanuaryTwoThousandMidday.plusSeconds(1);

        assertEquals(1, firstOfJanuaryTwoThousandMiddayAndOneSecond.getSecond());
    }

}
