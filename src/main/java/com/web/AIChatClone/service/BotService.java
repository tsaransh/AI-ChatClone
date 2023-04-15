package com.web.AIChatClone.service;

import com.web.AIChatClone.model.request.BotRequest;
import com.web.AIChatClone.model.response.ChatGptResponse;


public interface BotService {
    ChatGptResponse askFormChatGPT(BotRequest botRequest);
}
