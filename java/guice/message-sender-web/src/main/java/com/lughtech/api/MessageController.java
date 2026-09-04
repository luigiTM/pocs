package com.lughtech.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.lughtech.domain.Message;
import com.lughtech.service.MessageService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class MessageController extends HttpServlet {

    private final MessageService messageService;
    private final ObjectMapper objectMapper;

    @Inject
    public MessageController(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var body = request.getReader()
                .lines()
                .collect(Collectors.joining());
        var message = objectMapper.readValue(
                body,
                Message.class
        );
        messageService.sendMessage(message);
        response.getWriter().write("""
            {
                "message": "Message sent successfully"
            }
        """);
    }
}
