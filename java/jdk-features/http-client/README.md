# HTTP Client

Proof of concept for Java's built-in `HttpClient`.

## What It Covers

- Building HTTP/2 requests.
- Sending GET, POST, PUT, and DELETE requests.
- Applying request timeouts.
- Serializing request bodies with Jackson.
- Deserializing JSON responses into a `Post` model.

The demo targets the JSONPlaceholder posts API.

## Commands

Build the project:

```bash
./gradlew build
```

Run the `Main` class from an IDE or Java runner after compilation.

## Notes

Running the demo requires network access to
`https://jsonplaceholder.typicode.com`.
