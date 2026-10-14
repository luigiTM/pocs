import { useRef, useEffect } from "react";
import ChatMessage from "./ChatMessage"
import "./ChatMessages";


function ChatMessages({ chatMessages }) {
  // Creates a container with special React features
  const chatMessagesRef = useRef(null);
  // Run some code after the component is created or updated.
  useEffect(() => {
    const containerElement = chatMessagesRef.current;
    if (containerElement) {
      containerElement.scrollTop = containerElement.scrollHeight;
    }
  }, [chatMessages]);
  //       ^
  // The array controls when useEffect runs(Dependency array), if empty,
  // only runs once, whent the component is created,
  // or runs the code everytime the passed variables changes
  return (
    <div className="chat-messages-container" ref={chatMessagesRef}>
      {chatMessages.map((chatMessage) => {
        return (
          <ChatMessage
            key={chatMessage.id}
            message={chatMessage.message}
            sender={chatMessage.sender}
          />
        );
      })}
    </div>
  );
}

export default ChatMessages;