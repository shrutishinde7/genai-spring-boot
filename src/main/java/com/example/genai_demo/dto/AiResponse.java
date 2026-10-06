package com.example.genai_demo.dto;

public class AiResponse {

    private String prompt;
    private String response;

    public AiResponse(String prompt, String response) {
        this.prompt = prompt;
        this.response = response;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getResponse() {
        return response;
    }
}