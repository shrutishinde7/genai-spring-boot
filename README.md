# GenAI Spring Boot Application

A Spring Boot REST API that integrates with a Large Language Model through the Groq API.

## Features

- Accepts user prompts through a REST API
- Sends prompts to an LLM using Groq API
- Returns AI-generated responses
- Request validation
- Global exception handling
- Logging
- Secure API key configuration using environment variables

## Tech Stack

- Java
- Spring Boot
- REST API
- Groq API
- Large Language Model (LLM)
- Maven
- Postman

## API Endpoint

### Ask AI

POST `/api/ai/ask`

Request:

```json
{
  "prompt": "Explain dependency injection"
}
```

Response:

```json
{
  "prompt": "Explain dependency injection",
  "response": "AI generated response..."
}
```