# Simple Chatbot

A proof of concept for a chat interface built with React. The application lets users send messages, displays the conversation as chat bubbles, and generates automatic responses using the `supersimpledev/chatbot.js` library.

## Features

- Send messages through a text field
- Generate automatic chatbot responses
- Visually distinguish user and robot messages
- Display a welcome message when the conversation is empty
- Automatically scroll to the latest message
- Provide a responsive layout with a maximum width of 600 px

## Technologies

- HTML5
- CSS3
- React
- React DOM
- Babel for interpreting JSX directly in the browser
- `supersimpledev/chatbot.js` for generating responses

The JavaScript libraries are loaded from the [unpkg](https://unpkg.com/) CDN, so there are no dependencies to install and no build step is required.

## Project structure

```text
simple-chatbot/
├── chat-bot.html  # React components, styles, and application setup
├── robot.png      # Chatbot avatar
├── user.png       # User avatar
└── README.md
```

## Getting started

### Option 1: Open it in a browser

Open `chat-bot.html` directly in a modern web browser.

### Option 2: Run a local server

From the project directory, run:

```bash
python3 -m http.server 8000
```

Then visit:

```text
http://localhost:8000/chat-bot.html
```

An internet connection is required to load the libraries hosted on the CDN.

## Usage

1. Type a message in the text field at the bottom of the page.
2. Click **Send**.
3. The user's message and the chatbot's response will be added to the conversation.

## Code overview

The interface is split into four main components:

- `App`: stores the conversation state and organizes the interface
- `ChatInput`: controls the text field, sends messages, and requests chatbot responses
- `ChatMessages`: renders the message history and scrolls to the latest message
- `ChatMessage`: displays each message according to its sender

Messages are stored only in the page state. Refreshing or closing the browser clears the conversation history.
