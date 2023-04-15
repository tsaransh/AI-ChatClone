package com.web.AIChatClone.service;

import com.web.AIChatClone.config.ChatGPTConfig;
import com.web.AIChatClone.model.request.BotRequest;
import com.web.AIChatClone.model.request.ChatGptRequest;
import com.web.AIChatClone.model.response.ChatGptResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BotServiceImpl implements BotService{

    @Override
    public ChatGptResponse askFormChatGPT(BotRequest botRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGPTConfig.MODEL,
                                botRequest.getMessage(),
                                ChatGPTConfig.TEMPERATURE,
                                ChatGPTConfig.MAX_TOKEN,
                                ChatGPTConfig.TOP_P)));

    }

    private static RestTemplate restTemplate = new RestTemplate();

    //    Build headers
    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGPTConfig.MEDIA_TYPE));
        headers.add(ChatGPTConfig.AUTHORIZATION, ChatGPTConfig.BEARER + ChatGPTConfig.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGPTConfig.URL,
                chatRequestHttpEntity,
                ChatGptResponse.class);

        return responseEntity.getBody();
    }
}
