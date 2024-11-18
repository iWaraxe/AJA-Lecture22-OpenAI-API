Spring Boot AI-Enhanced Country Information API

This project is a Spring Boot application that provides a RESTful API for retrieving information about countries and their capitals using OpenAI’s GPT technology. The application demonstrates how to integrate AI services into a Spring Boot project, allowing users to ask general questions, get the capital of a country, and retrieve detailed information about a capital city.

Table of Contents

	•	Description
	•	Prerequisites
	•	Setup Instructions
	•	Running the Application
	•	Testing the Application
	•	Obtaining OpenAI API Key
	•	Setting the Environment Variable
	•	Additional Notes

Description

The application exposes the following endpoints:
•	POST /ask: Accepts a general question and returns an AI-generated answer.
•	POST /capital: Takes a country name and returns the capital city in a structured JSON format.
•	POST /capitalWithInfo: Provides additional information about the capital city, such as population, region, language, and currency.

Prerequisites

Before you begin, ensure you have the following installed on your system:
•	Java Development Kit (JDK) 17 or higher: Download JDK
•	Maven (preferred) or Gradle: Build tools to manage project dependencies.
•	Git: To clone the repository.
•	OpenAI API Key: Required to access OpenAI services.

Setup Instructions

1. Cloning the Repository

Clone the project repository to your local machine:

git clone https://github.com/your-username/springai-intro.git

Navigate to the project directory:

cd springai-intro

2. Obtaining OpenAI API Key

To use OpenAI’s services, you need an API key.
1.	Sign Up / Log In: Visit the OpenAI website and sign up for an account or log in if you already have one.
2.	Navigate to API Keys:
•	After logging in, go to your account dashboard.
•	Click on your profile icon in the top-right corner and select “View API keys”.
3.	Create a New API Key:
•	Click on “Create new secret key”.
•	Copy the generated API key. This is the only time you will see it, so make sure to copy it now.
Note: Keep your API key secure and do not share it publicly.

3. Setting the Environment Variable

The application expects the OpenAI API key to be set as an environment variable named OPENAI_API_KEY.

For Windows:

Open Command Prompt or PowerShell and run:

set OPENAI_API_KEY=your_actual_api_key

Replace your_actual_api_key with the API key you obtained from OpenAI.

For Linux and macOS:

Open Terminal and run:

export OPENAI_API_KEY=your_actual_api_key

Persistent Environment Variable (Optional):

To avoid setting the variable each time, you can add it to your system’s environment variables or include it in your shell profile (e.g., .bashrc, .zshrc).

4. Verifying the Environment Variable

To ensure the environment variable is set correctly, you can print it in your terminal:

Windows:

echo %OPENAI_API_KEY%

Linux and macOS:

echo $OPENAI_API_KEY

You should see your API key printed out.

Running the Application

Using Maven

The project uses Maven for dependency management. You can run the application using the following command:

mvn spring-boot:run

Using an IDE

Alternatively, you can import the project into an IDE like IntelliJ IDEA or Eclipse and run the SpringaiIntroApplication main class.

Testing the Application

You can use Postman or any other API testing tool to interact with the endpoints.

1. POST /ask

   •	URL: http://localhost:8080/ask
   •	Headers: Content-Type: application/json
   •	Body:

{
"question": "What is the tallest mountain in the world?"
}


	•	Response:

{
"answer": "The tallest mountain in the world is Mount Everest."
}



2. POST /capital

   •	URL: http://localhost:8080/capital
   •	Headers: Content-Type: application/json
   •	Body:

{
"stateOrCountry": "Japan"
}


	•	Response:

{
"answer": "Tokyo"
}



3. POST /capitalWithInfo

   •	URL: http://localhost:8080/capitalWithInfo
   •	Headers: Content-Type: application/json
   •	Body:

{
"stateOrCountry": "Japan"
}


	•	Response:

{
"answer": "The capital of Japan is Tokyo.\nThe city has a population of 13.96 million.\nThe city is located in the Kantō region.\nThe primary language spoken is Japanese.\nThe currency used is Japanese Yen."
}



Additional Notes

	•	Error Handling: Ensure that the stateOrCountry you provide is spelled correctly. The AI may not return accurate results for misspelled or unrecognized names.
	•	API Limits: Be mindful of the OpenAI API usage limits associated with your account to avoid unexpected charges.
	•	Logging: The application may print logs to the console for debugging purposes. You can configure logging levels in the application.properties file.

Project Structure

	•	controllers/QuestionController.java: Handles HTTP requests and defines the API endpoints.
	•	services/OpenAIService.java: Interface defining the methods for interacting with OpenAI.
	•	services/OpenAIServiceImpl.java: Implements the OpenAIService interface and contains logic for calling the OpenAI API.
	•	model/: Contains the data models (Answer, Question, GetCapitalRequest, GetCapitalResponse) used in the application.
	•	resources/templates/: Stores the prompt templates used to structure requests to OpenAI.
	•	application.properties: Configuration file for the application.

Troubleshooting

	•	Common Issues:
	•	If you receive an authentication error, ensure your OPENAI_API_KEY is set correctly.
	•	If the application cannot find the templates, check that the templates directory is in the correct location (src/main/resources/templates/).
	•	Getting Help:
	•	Refer to the OpenAI API documentation for details on API usage.
	•	For issues related to the Spring Boot application, consult the Spring Boot documentation.

Disclaimer: This project is for educational purposes. Ensure you comply with OpenAI’s terms of service and policies when using their API.