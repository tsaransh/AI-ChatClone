package com.web.AIChatClone.controller;


import com.web.AIChatClone.model.request.BotRequest;
import com.web.AIChatClone.model.response.ChatGptResponse;
import com.web.AIChatClone.service.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai-chat/clone")
@RequiredArgsConstructor
public class ChatGptController {

    @PostMapping("/hello")
    public String sayHEllo() {
        return "Hello World!";
    }
    @Autowired
    private final BotService botService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest) {
        System.err.println("request received for "+ botRequest.getMessage());
        return botService.askFormChatGPT(botRequest);
    }

}
