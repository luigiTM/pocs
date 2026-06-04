package com.lughtech.javatime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationAndPeriodTest {

    @Test
    void shouldHaveTwoHoursOfDuration() {
        var midday = LocalTime.of(12, 0, 0);
        var twoHours = LocalTime.of(14, 0, 0);
        var duration = Duration.between(midday, twoHours);

        assertEquals(2, duration.toHours());
    }

    @Test
    void shouldHaveOneHundredAndTwentyMinutesOfDuration() {
        var midday = LocalTime.of(12, 0, 0);
        var twoHours = LocalTime.of(14, 0, 0);
        var duration = Duration.between(midday, twoHours);

        assertEquals(120, duration.toMinutes());
    }

    @Test
    void shouldHaveSevenThousandAndTwoHundredSecondsOfDuration() {
        var midday = LocalTime.of(12, 0, 0);
        var twoHours = LocalTime.of(14, 0, 0);
        var duration = Duration.between(midday, twoHours);

        assertEquals(7200, duration.toSeconds());
    }

    @Test
    void shouldHaveTwoDaysOfPeriod() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var thirdOfJanuaryTwoThousand = LocalDate.of(2000, 1, 3);
        var period = Period.between(firstOfJanuaryTwoThousand, thirdOfJanuaryTwoThousand);

        assertEquals(2, period.getDays());
    }

    @Test
    void shouldHaveTwoMonthsOfPeriod() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var firstOfMarchTwoThousand = LocalDate.of(2000, 3, 1);
        var period = Period.between(firstOfJanuaryTwoThousand, firstOfMarchTwoThousand);

        assertEquals(2, period.getMonths());
    }

    @Test
    void shouldHaveTwoYearsOfPeriod() {
        var firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        var firstOfJanuaryTwoThousandAndTwo = LocalDate.of(2002, 1, 1);
        var period = Period.between(firstOfJanuaryTwoThousand, firstOfJanuaryTwoThousandAndTwo);

        assertEquals(2, period.getYears());
    }
}
