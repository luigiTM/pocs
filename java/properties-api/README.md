# Java Properties API PoC

Demonstrates how to load, read, update, and remove values from Java properties
files.

## What It Shows

- Loading standard `.properties` files.
- Loading XML properties files.
- Hiding format-specific logic behind a `PropertiesHandler` interface.
- Managing application configuration with `ConfigService`.
- Unit tests for handlers and service behavior.

## Key Files

- `src/main/java/com/lughtech/properties/config/PropertiesHandler.java`
- `src/main/java/com/lughtech/properties/config/impl/RegularPropertiesHandler.java`
- `src/main/java/com/lughtech/properties/config/impl/XmlPropertiesHandler.java`
- `src/main/java/com/lughtech/properties/service/ConfigService.java`
- `src/main/resources/app.properties`
- `src/main/resources/app.xml`
- `src/test/java/com/lughtech/properties`

## Run

```bash
./gradlew test
```

The `Main` class demonstrates loading a properties file, reading the application
name, updating it, and removing it.
