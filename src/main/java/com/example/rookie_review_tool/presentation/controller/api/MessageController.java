package com.example.rookie_review_tool.presentation.controller.api;

import com.example.rookie_review_tool.presentation.dto.request.MessageRequest;
import com.example.rookie_review_tool.presentation.dto.response.MessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/receive/message")
    public MessageResponse send(MessageRequest message) throws Exception {
        Thread.sleep(1000);

        return MessageResponse.of(message.getSendingUserName(), message.getDetail());
    }
}
