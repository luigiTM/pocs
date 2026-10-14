import { useState } from "react";
import { Chatbot } from "supersimpledev";
import "./ChatInput.css";

function ChatInput({ chatMessages, setChatMessages }) {
  const [inputText, setInputText] = useState("");

  function saveInpuText(event) {
    const input = event.target;
    setInputText(input.value);
  }

  function sendMessage() {
    const newChatMessages = [
      ...chatMessages,
      {
        id: crypto.randomUUID(),
        message: inputText,
        sender: "user",
      },
    ];
    const response = Chatbot.getResponse(inputText);
    setChatMessages([
      ...newChatMessages,
      {
        id: crypto.randomUUID(),
        message: response,
        sender: "robot",
      },
    ]);
    setInputText("");
  }

  return (
    <div className="chat-input-container">
      <input
        className="chat-input"
        placeholder="Send a message to ChatBot"
        size="30"
        onChange={saveInpuText}
        value={inputText}
      />
      <button className="send-button" onClick={sendMessage}>
        Send
      </button>
    </div>
  );
}

export default ChatInput;