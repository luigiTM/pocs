# Simple Chatbot (Vite)

A React chat interface built with Vite. Users can send messages and receive
responses from the `supersimpledev` chatbot library. The interface is split
into chat input, message list, and message bubble components; conversation
state is held in the page and resets when it is refreshed.

## Requirements

- Node.js
- pnpm

## Run locally

From this directory:

```bash
pnpm install
pnpm dev
```

Vite prints the local URL when the development server starts. Build and lint
the project with:

```bash
pnpm build
pnpm lint
```

The chatbot library is installed as a project dependency, so the app does not
load it from a CDN.
