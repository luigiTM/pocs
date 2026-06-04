package com.lughtech.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationAndPeriodTest {

    @Test
    void shouldHaveTwoHoursOfDuration() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandTwoHours = DateTime.parse("2000-01-01T14:00:00");
        var duration = new Duration(firstOfJanuaryTwoThousandMidday, firstOfJanuaryTwoThousandTwoHours);

        assertEquals(2, duration.getStandardHours());
    }

    @Test
    void shouldHaveOneHundredAndTwentyMinutesOfDuration() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandTwoHours = DateTime.parse("2000-01-01T14:00:00");
        var duration = new Duration(firstOfJanuaryTwoThousandMidday, firstOfJanuaryTwoThousandTwoHours);

        assertEquals(120, duration.getStandardMinutes());
    }

    @Test
    void shouldHaveSevenThousandAndTwoHundredSecondsOfDuration() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandTwoHours = DateTime.parse("2000-01-01T14:00:00");
        var duration = new Duration(firstOfJanuaryTwoThousandMidday, firstOfJanuaryTwoThousandTwoHours);

        assertEquals(7200, duration.getStandardSeconds());
    }

    @Test
    void shouldHaveTwoDaysForPeriod() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var thirdOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-03T12:00:00");
        var period = new Period(firstOfJanuaryTwoThousandMidday, thirdOfJanuaryTwoThousandMidday);

        assertEquals(2, period.getDays());
    }

    @Test
    void shouldHaveTwoMonthsForPeriod() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfMarchTwoThousandMidday = DateTime.parse("2000-03-01T12:00:00");
        var period = new Period(firstOfJanuaryTwoThousandMidday, firstOfMarchTwoThousandMidday);

        assertEquals(2, period.getMonths());
    }

    @Test
    void shouldHaveTwoYearsForPeriod() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandAndTwoMidday = DateTime.parse("2002-01-03T12:00:00");
        var period = new Period(firstOfJanuaryTwoThousandMidday, firstOfJanuaryTwoThousandAndTwoMidday);

        assertEquals(2, period.getYears());
    }
}
