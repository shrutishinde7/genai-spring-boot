package com.example.genai_demo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AiRequest {

    @NotBlank(message = "Prompt cannot be empty")
    @Size(max = 1000, message = "Prompt cannot exceed 1000 characters")
    private String prompt;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
