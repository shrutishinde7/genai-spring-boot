# GenAI Spring Boot Application

A Spring Boot REST API that integrates with a Large Language Model (LLM) through the Groq API.

This project demonstrates how a backend application can accept a user prompt, send it to an external LLM API, process the AI response, and return the result through a REST API.

## Features

- Accepts user prompts through a REST API
- Integrates with a Large Language Model using the Groq API
- Returns AI-generated responses
- Request validation
- Global exception handling
- Error logging
- Secure API key configuration using environment variables
- Clean layered architecture using Controller, Service, and DTOs

## Tech Stack

- Java
- Spring Boot
- REST API
- Groq API
- Large Language Model (LLM)
- Maven
- Postman

## Project Architecture

Client / Postman  
↓  
POST /api/ai/ask  
↓  
AiController  
↓  
AiService  
↓  
RestClient  
↓  
Groq API  
↓  
Large Language Model  
↓  
GroqResponse  
↓  
AiResponse  
↓  
Client / Postman

## Project Structure

src/main/java/com/example/genai_demo/

- controller/
  - AiController.java
- dto/
  - AiRequest.java
  - AiResponse.java
  - GroqRequest.java
  - GroqResponse.java
- exception/
  - GlobalExceptionHandler.java
- service/
  - AiService.java
- GenaiDemoApplication.java

## API Endpoint

### Ask AI

POST `/api/ai/ask`

### Request

Prompt:

"Explain dependency injection in simple language"

### Response

The API returns the original prompt together with the AI-generated response.

Example:

Prompt: "Explain dependency injection in simple language"

Response: "Dependency Injection is a design pattern..."

## Request Validation

The application validates incoming prompts.

For example:

- Prompt cannot be empty
- Prompt cannot exceed 1000 characters

Example invalid request:

Prompt: ""

The application returns a validation error instead of processing the request.

## Global Exception Handling

The project uses `@RestControllerAdvice` to handle validation exceptions globally.

This keeps error-handling logic separate from the controller.

Example error:

"Prompt cannot be empty"

## Groq API Integration

The application uses Spring's `RestClient` to communicate with the Groq API.

The backend:

1. Receives the prompt from the client.
2. Creates a request containing the model and messages.
3. Sends an HTTP POST request to the Groq API.
4. Receives the LLM response.
5. Extracts the generated content.
6. Returns the response to the client.

The relevant response data is extracted from:

`choices[0].message.content`

## Environment Configuration

The Groq API key is not stored directly in the source code.

The application reads it from an environment variable:

`GROQ_API_KEY=your_api_key`

The `application.properties` file uses:

`groq.api.key=${GROQ_API_KEY}`

`groq.api.url=https://api.groq.com/openai/v1/chat/completions`

`groq.model=openai/gpt-oss-20b`

> Never commit or share your actual API key.

## How to Run

### 1. Clone the repository

`git clone https://github.com/shrutishinde7/genai-spring-boot.git`

### 2. Open the project

Open the project in IntelliJ IDEA or another Java IDE.

### 3. Configure the API key

Set the environment variable:

`GROQ_API_KEY=your_api_key`

### 4. Run the application

On Windows:

`mvnw.cmd spring-boot:run`

Or run `GenaiDemoApplication.java` directly from IntelliJ IDEA.

### 5. Test the API

The application runs on:

`http://localhost:8080`

Use Postman to send:

`POST http://localhost:8080/api/ai/ask`

Example prompt:

"What is dependency injection in Spring Boot?"

## Example Flow

User enters prompt  
↓  
Postman sends HTTP POST request  
↓  
AiController receives request  
↓  
AiService processes the prompt  
↓  
RestClient sends request to Groq API  
↓  
Groq LLM generates response  
↓  
AiService extracts generated text  
↓  
AiController returns JSON response  
↓  
Postman displays AI response

## Important Note

This project does not train an LLM.

It integrates an existing pre-trained Large Language Model through the Groq API.

The Spring Boot application acts as the backend layer between the client and the external AI service.

## Future Enhancements

Possible future improvements include:

- Add a React frontend
- Add conversation history
- Add multiple AI models
- Add authentication and authorization
- Add database support for storing conversations
- Add API documentation using Swagger/OpenAPI
- Add automated tests
- Improve API error handling
- Add rate limiting

## Author

**Shruti Shinde**

GitHub:

https://github.com/shrutishinde7
