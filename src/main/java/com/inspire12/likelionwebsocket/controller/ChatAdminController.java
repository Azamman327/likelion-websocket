package com.inspire12.likelionwebsocket.controller;

import com.inspire12.likelionwebsocket.model.ChatMessage;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatAdminController {
    private final SimpMessagingTemplate messagingTemplate;

    public ChatAdminController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/call")
    public ChatMessage call(@RequestBody ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/publish", chatMessage);
        return chatMessage;
    }
}
