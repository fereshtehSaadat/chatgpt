package org.fsx.chatgpt.controller.service;

import lombok.RequiredArgsConstructor;
import org.fsx.chatgpt.business.ChatGptApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController(value = "/chatgpthome")
public class ChatGptBotController {

    private final ChatGptApi chatGptApi;

    @PostMapping("/chatbot")
    public String chatbot(@RequestBody String ask) throws IOException {
        return chatGptApi.getAnswer(ask);
    }
}
