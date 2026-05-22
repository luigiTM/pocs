package com.lughtech.javatime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreationTest {

    @Test
    @DisplayName("Should create current date")
    void shouldCreateCurrentDate() {

        LocalDate currentDate = LocalDate.now();

        assertNotNull(currentDate);
    }

    @Test
    @DisplayName("Should create current date time")
    void shouldCreateCurrentDateTime() {

        LocalDateTime currentDateTime = LocalDateTime.now();

        assertNotNull(currentDateTime);
    }

    @Test
    @DisplayName("Should create specific date")
    void shouldCreateSpecificDate() {

        LocalDate date = LocalDate.of(2026, 5, 21);

        assertEquals(2026, date.getYear());
        assertEquals(5, date.getMonthValue());
        assertEquals(21, date.getDayOfMonth());
    }

    @Test
    @DisplayName("Should create specific date time")
    void shouldCreateSpecificDateTime() {

        LocalDateTime dateTime =
                LocalDateTime.of(2026, 5, 21, 10, 30);

        assertEquals(2026, dateTime.getYear());
        assertEquals(5, dateTime.getMonthValue());
        assertEquals(21, dateTime.getDayOfMonth());
        assertEquals(10, dateTime.getHour());
        assertEquals(30, dateTime.getMinute());
    }

    @Test
    @DisplayName("Should create date from timestamp")
    void shouldCreateDateFromTimestamp() {

        long timestamp = 1_779_377_600_000L;

        Instant instant = Instant.ofEpochMilli(timestamp);

        assertEquals(timestamp, instant.toEpochMilli());
    }

    @Test
    @DisplayName("Should create UTC date")
    void shouldCreateUtcDate() {

        ZonedDateTime utcDate =
                ZonedDateTime.now(ZoneId.of("UTC"));

        assertEquals("UTC", utcDate.getZone().getId());
    }

    @Test
    @DisplayName("Should create date with timezone")
    void shouldCreateDateWithTimezone() {

        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime zonedDateTime =
                ZonedDateTime.now(zoneId);

        assertEquals("America/Sao_Paulo",
                zonedDateTime.getZone().getId());
    }

    @Test
    @DisplayName("Should convert date to instant")
    void shouldConvertDateToInstant() {

        ZonedDateTime zonedDateTime =
                ZonedDateTime.now();

        Instant instant = zonedDateTime.toInstant();

        assertNotNull(instant);
    }

    @Test
    @DisplayName("Should convert instant to local date")
    void shouldConvertInstantToLocalDate() {

        Instant instant = Instant.now();

        LocalDate localDate =
                instant.atZone(ZoneId.systemDefault())
                        .toLocalDate();

        assertNotNull(localDate);
    }

    @Test
    @DisplayName("Should validate invalid date")
    void shouldValidateInvalidDate() {

        assertThrows(DateTimeException.class, () ->
                LocalDate.of(2026, 2, 30)
        );
    }
}
