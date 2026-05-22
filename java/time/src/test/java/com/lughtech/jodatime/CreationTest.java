package com.lughtech.jodatime;

import org.joda.time.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreationTest {

    @Test
    @DisplayName("Should create current date")
    void shouldCreateCurrentDate() {
        var now = LocalDate.now();

        assertNotNull(now);
    }

    @Test
    @DisplayName("Should create current date time")
    void shouldCreateCurrentDateTime() {
        var now = DateTime.now();

        assertNotNull(now);
    }

    @Test
    @DisplayName("Should create specific date")
    void shouldCreateSpecificDate() {
        var specificDate = new LocalDate(2000, 1, 1);

        assertEquals(2000, specificDate.getYear());
        assertEquals(1, specificDate.getMonthOfYear());
        assertEquals(1, specificDate.getDayOfMonth());
    }

    @Test
    @DisplayName("Should create specific date time")
    void shouldCreateSpecificDateTime() {
        var specificDateTime = new DateTime(2000, 1, 1, 0,0,0,0);

        assertEquals(2000, specificDateTime.getYear());
        assertEquals(1, specificDateTime.getMonthOfYear());
        assertEquals(1, specificDateTime.getDayOfMonth());
        assertEquals(0, specificDateTime.getHourOfDay());
        assertEquals(0, specificDateTime.getMinuteOfDay());
        assertEquals(0, specificDateTime.getSecondOfDay());
        assertEquals(0, specificDateTime.getMillisOfDay());
    }

    @Test
    @DisplayName("Should create date from timestamp")
    void shouldCreateDateFromTimestamp() {

        long timestamp = 1_779_377_600_000L;

        Instant instant = new Instant(timestamp);

        assertEquals(timestamp, instant.getMillis());
    }

    @Test
    @DisplayName("Should create UTC date")
    void shouldCreateUtcDate() {

        DateTime utcDate =
                DateTime.now(DateTimeZone.UTC);

        assertEquals("UTC", utcDate.getZone().getID());
    }

    @Test
    @DisplayName("Should create date with timezone")
    void shouldCreateDateWithTimezone() {

        DateTimeZone zone =
                DateTimeZone.forID("America/Sao_Paulo");

        DateTime zonedDateTime =
                DateTime.now(zone);

        assertEquals("America/Sao_Paulo",
                zonedDateTime.getZone().getID());
    }

    @Test
    @DisplayName("Should convert date to instant")
    void shouldConvertDateToInstant() {

        DateTime dateTime = DateTime.now();

        Instant instant = dateTime.toInstant();

        assertNotNull(instant);
    }

    @Test
    @DisplayName("Should convert instant to local date")
    void shouldConvertInstantToLocalDate() {

        Instant instant = Instant.now();

        LocalDate localDate =
                instant.toDateTime().toLocalDate();

        assertNotNull(localDate);
    }

    @Test
    @DisplayName("Should validate invalid date")
    void shouldValidateInvalidDate() {

        assertThrows(IllegalFieldValueException.class, () ->
                new LocalDate(2026, 2, 30)
        );
    }
}
