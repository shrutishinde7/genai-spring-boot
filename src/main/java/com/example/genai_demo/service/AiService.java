package com.example.genai_demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.genai_demo.dto.GroqRequest;
import com.example.genai_demo.dto.GroqResponse;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AiService {

    private static final Logger logger =
            LoggerFactory.getLogger(AiService.class);

    private final RestClient restClient;

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.url}")
    private String apiUrl;

    @Value("${groq.model}")
    private String model;

    public AiService() {
        this.restClient = RestClient.create();
    }

    public String getResponse(String prompt) {

        try {
            GroqRequest.Message systemMessage =
                    new GroqRequest.Message(
                            "system",
                            "You are a helpful Java interview assistant. " +
                                    "Explain concepts in simple language with practical examples."
                    );

            GroqRequest.Message userMessage =
                    new GroqRequest.Message("user", prompt);

            GroqRequest request =
                    new GroqRequest(
                            model,
                            List.of(systemMessage, userMessage)
                    );

            GroqResponse response = restClient
                    .post()
                    .uri(apiUrl)
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .body(request)
                    .retrieve()
                    .body(GroqResponse.class);

            return response.getChoices()
                    .get(0)
                    .getMessage()
                    .getContent();

        } catch (Exception e) {
            logger.error("Error while calling Groq API", e);
            return "Unable to get response from AI service.";
        }
    }
}