package com.lughtech.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationAndPeriodTest {

    @Test
    void shouldHaveTwoHoursOfDuration() {
        var firstOfJanuaryTwoThousandMidday = DateTime.parse("2000-01-01T12:00:00");
        var firstOfJanuaryTwoThousandTwoHours = DateTime.parse("2000-01-01T14:00:00");
        var duration = Duration.millis(firstOfJanuaryTwoThousandTwoHours.getMillis() - firstOfJanuaryTwoThousandMidday.getMillis());

        assertEquals(2, duration.getStandardHours());
    }
}
