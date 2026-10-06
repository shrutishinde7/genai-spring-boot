package com.example.genai_demo.controller;

import com.example.genai_demo.dto.AiRequest;
import com.example.genai_demo.dto.AiResponse;
import com.example.genai_demo.service.AiService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService){
        this.aiService=aiService;
    }
    @GetMapping("/hello")
    public String hello() {
        return aiService.getResponse("hello");
    }

    @PostMapping("/ask")
    public AiResponse ask(@Valid @RequestBody AiRequest request) {

        String aiResponse = aiService.getResponse(request.getPrompt());

        return new AiResponse(
                request.getPrompt(),
                aiResponse
        );
    }
}