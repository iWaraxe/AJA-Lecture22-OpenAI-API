package com.coherentsolutions.springaiintro.services;

import com.coherentsolutions.springaiintro.model.Answer;
import com.coherentsolutions.springaiintro.model.GetCapitalRequest;
import com.coherentsolutions.springaiintro.model.GetCapitalResponse;
import com.coherentsolutions.springaiintro.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * The {@code OpenAIServiceImpl} class provides the implementation of the {@link OpenAIService} interface.
 * <p>
 * This class handles communication with the OpenAI API using a {@link ChatClient}.
 * It constructs prompts, sends them to the API, and processes responses.
 * </p>
 * <p>
 * It also demonstrates how to use Spring features like {@code @Value} for loading resources and
 * {@code @PostConstruct} for initialization logic.
 * </p>
 */
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    /**
     * Resource file for the template used to get the capital city of a state or country.
     */
    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    /**
     * Resource file for the template used to get detailed information about a capital city.
     */
    @Value("classpath:templates/get-capital-with-info.st")
    private Resource getCapitalPromptWithInfo;

    /**
     * Constructs a new {@code OpenAIServiceImpl} and injects the {@code ChatClient} dependency.
     *
     * @param chatClient The chat client used to interact with the OpenAI API.
     */
    public OpenAIServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    /**
     * This method runs after the bean is initialized and checks whether the templates exist in the classpath.
     * <p>
     * It prints the content of the template to the console for debugging purposes.
     * </p>
     */
    @PostConstruct
    public void init() {
        try {
            System.out.println("Template exists: " + getCapitalPrompt.exists());
            System.out.println("Template content: " + new String(getCapitalPrompt.getInputStream().readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes a {@link Question} object and retrieves an {@link Answer}.
     * <p>
     * This method creates a prompt from the question, sends it to the OpenAI API, and
     * returns the answer as an {@code Answer} object.
     * </p>
     *
     * @param question A structured question provided by the client.
     * @return An {@link Answer} object containing the response to the question.
     */
    @Override
    public Answer getAnswer(Question question) {
        // Create a prompt from the question text.
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();

        // Call the OpenAI API and process the response.
        ChatResponse response = chatClient.call(prompt);
        return new Answer(response.getResult().getOutput().getContent());
    }

    /**
     * Processes a question provided as a plain {@link String} and retrieves the answer as a {@link String}.
     *
     * @param question A plain text question provided by the client.
     * @return The answer as a plain text {@link String}.
     */
    @Override
    public String getAnswer(String question) {
        // Create a prompt from the plain text question.
        Prompt prompt = new PromptTemplate(question).create();

        // Call the OpenAI API and return the response content as a string.
        ChatResponse response = chatClient.call(prompt);
        return response.getResult().getOutput().getContent();
    }

    /**
     * Retrieves the capital city of a specified state or country.
     * <p>
     * This method uses a template to construct a prompt and parses the response into a {@link GetCapitalResponse}.
     * </p>
     *
     * @param getCapitalRequest A request object containing the name of the state or country.
     * @return A {@link GetCapitalResponse} object containing the name of the capital city.
     */
    @Override
    public GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest) {
        // Create a parser for the response to map it to a GetCapitalResponse object.
        BeanOutputParser<GetCapitalResponse> parser = new BeanOutputParser<>(GetCapitalResponse.class);
        String format = parser.getFormat(); // Get the format required for parsing.

        // Use the getCapitalPrompt template to create a prompt with parameters.
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of(
                "stateOrCountry", getCapitalRequest.stateOrCountry(),
                "format", format
        ));

        // Call the OpenAI API and parse the response.
        ChatResponse response = chatClient.call(prompt);
        return parser.parse(response.getResult().getOutput().getContent());
    }

    /**
     * Retrieves detailed information about the capital city of a specified state or country.
     * <p>
     * This method uses a template to construct a prompt and returns the result as an {@link Answer}.
     * </p>
     *
     * @param getCapitalRequest A request object containing the name of the state or country.
     * @return An {@link Answer} object containing detailed information about the capital city.
     */
    @Override
    public Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest) {
        // Use the getCapitalPromptWithInfo template to create a prompt with parameters.
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPromptWithInfo);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getCapitalRequest.stateOrCountry()));

        // Call the OpenAI API and process the response.
        ChatResponse response = chatClient.call(prompt);
        return new Answer(response.getResult().getOutput().getContent());
    }
}