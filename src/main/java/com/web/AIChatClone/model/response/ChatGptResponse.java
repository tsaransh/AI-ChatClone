package com.web.AIChatClone.model.response;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class ChatGptResponse {
    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<Choice> choices;
}
