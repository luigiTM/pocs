# Programming Joke Skill

Fetch and share a programming joke with the user.

## When to use
- The user asks for a joke.
- The user asks to be cheered up with a joke.

## When not to use
- The user is discussing a serious or sensitive situation where a joke would be inappropriate.
- The user asks for factual information rather than a joke.

## Usage

Use the `getJoke` function exported by the skill's `index.js`. It fetches a single Programming-category joke. Do not switch to another joke category or provider.

If the function returns a `joke`, present that text as the joke without changing its meaning. If it returns `error`, briefly say that a joke could not be fetched. Do not invent a replacement joke in that case.
