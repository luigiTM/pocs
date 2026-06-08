# JDK Features PoCs

Standalone Gradle projects focused on features from modern JDK releases.

## Projects

| PoC | Focus | How to verify |
| --- | --- | --- |
| [http-client](http-client) | Java `HttpClient` requests with JSON serialization and deserialization through Jackson. | `cd java/jdk-features/http-client && ./gradlew build` |
| [switch-expressions](switch-expressions) | A small arithmetic calculator implemented with switch expressions. | `cd java/jdk-features/switch-expressions && ./gradlew test` |

## Requirements

- JDK installed locally.
- No global Gradle installation is required because each project includes
  `gradlew`.

## Notes

- The HTTP client demo calls JSONPlaceholder, so running its `Main` class
  requires network access.
