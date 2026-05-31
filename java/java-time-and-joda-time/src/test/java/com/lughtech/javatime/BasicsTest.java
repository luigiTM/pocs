package com.lughtech.javatime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BasicsTest {

    @Test
    void shouldCreateLocalDateWithCurrentDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    void shouldCreateLocalDateWithDefinedDate() {
        LocalDate firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);

        assertEquals(2000, firstOfJanuaryTwoThousand.getYear());
        assertEquals(1, firstOfJanuaryTwoThousand.getMonth().getValue());
        assertEquals(1, firstOfJanuaryTwoThousand.getDayOfMonth());
    }

    @Test
    void shouldCreateLocalTimeWithCurrentTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    void shouldCreateLocalTimeWithDefinedTime() {
        LocalTime midday = LocalTime.of(12, 0);

        assertEquals(12, midday.getHour());
        assertEquals(0, midday.getMinute());
    }

    @Test
    void shouldCreateLocalDateTimeWithCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        assertNotNull(now);
    }

    @Test
    void shouldCreateLocalDateTimeWithDefinedDateAndTime() {
        LocalDateTime firstOfJanuaryTwoThousandMidday = LocalDateTime.of(2000, 1, 1, 12, 0);

        assertEquals(2000, firstOfJanuaryTwoThousandMidday.getYear());
        assertEquals(1, firstOfJanuaryTwoThousandMidday.getMonth().getValue());
        assertEquals(1, firstOfJanuaryTwoThousandMidday.getDayOfMonth());
        assertEquals(12, firstOfJanuaryTwoThousandMidday.getHour());
        assertEquals(0, firstOfJanuaryTwoThousandMidday.getMinute());
    }

    @Test
    void shouldCreateNewLocalDateWithoutChangingOrigin() {
        LocalDate firstOfJanuaryTwoThousand = LocalDate.of(2000, 1, 1);
        LocalDate secondOfJanuaryTwoThousand = firstOfJanuaryTwoThousand.plusDays(1);

        assertEquals(1, firstOfJanuaryTwoThousand.getDayOfMonth());
        assertEquals(2, secondOfJanuaryTwoThousand.getDayOfMonth());
        assertEquals(secondOfJanuaryTwoThousand.getDayOfMonth(), firstOfJanuaryTwoThousand.getDayOfMonth() + 1);
    }

    @Test
    void shouldCompareTwoLocalDates() {
        LocalDate now = LocalDate.now();
        LocalDate nowAgain = LocalDate.now();

        assertEquals(0, now.compareTo(nowAgain));
    }

    @Test
    void shouldCreateNewLocalTimeWithoutChangingOrigin() {
        LocalTime midday = LocalTime.of(12, 0);
        LocalTime oneHour = midday.plusHours(1);

        assertEquals(12, midday.getHour());
        assertEquals(13, oneHour.getHour());
        assertEquals(oneHour.getHour(), midday.getHour() + 1);
    }

    @Test
    void shouldCompareTwoLocalTimes() {
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalTime nowAgain = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);

        assertEquals(0, now.compareTo(nowAgain));
    }

}
