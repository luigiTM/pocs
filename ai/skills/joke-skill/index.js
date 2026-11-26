async function getJoke() {
  try {
    const response = await fetch("https://v2.jokeapi.dev/joke/Programming?type=single");

    if (!response.ok) {
      return { error: `Joke API returned ${response.status}` };
    }

    const data = await response.json();

    if (data.error || typeof data.joke !== "string") {
      return { error: "Joke API did not return a programming joke" };
    }

    return {
      joke: data.joke,
      category: "Programming",
      safe: data.safe === true
    };
  } catch (err) {
    const message = err instanceof Error ? err.message : String(err);
    return { error: `Failed to fetch joke: ${message}` };
  }
}

module.exports = { getJoke };
