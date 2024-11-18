package com.coherentsolutions.springaiintro.controllers;

import com.coherentsolutions.springaiintro.model.Answer;
import com.coherentsolutions.springaiintro.model.GetCapitalRequest;
import com.coherentsolutions.springaiintro.model.GetCapitalResponse;
import com.coherentsolutions.springaiintro.model.Question;
import com.coherentsolutions.springaiintro.services.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code QuestionController} class is responsible for handling HTTP requests related to
 * asking general questions and retrieving capital city information about countries.
 * <p>
 * This controller exposes three endpoints:
 * <ul>
 *     <li>{@code /ask} - For general question answering.</li>
 *     <li>{@code /capital} - To get the capital city of a specified country.</li>
 *     <li>{@code /capitalWithInfo} - To get detailed information about a country's capital city.</li>
 * </ul>
 * <p>
 * The class is annotated with {@link RestController}, which is a convenience annotation that combines
 * {@link org.springframework.stereotype.Controller @Controller} and {@link org.springframework.web.bind.annotation.ResponseBody @ResponseBody}.
 * This means that each method returns a domain object instead of a view, and the object is serialized into JSON automatically.
 * </p>
 */
@RestController
public class QuestionController {

    /**
     * The service used to interact with the OpenAI API.
     * It's marked as {@code final} because its value is assigned only once in the constructor.
     */
    private final OpenAIService openAIService;

    /**
     * Constructs a new {@code QuestionController} and injects the {@code OpenAIService} dependency.
     * <p>
     * The {@link Autowired} annotation tells Spring to automatically wire an instance of {@code OpenAIService}
     * into this constructor. This is known as constructor-based dependency injection.
     * </p>
     *
     * @param openAIService The service used to process questions and capital requests.
     */
    @Autowired
    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    /**
     * Handles HTTP POST requests to the {@code /ask} endpoint.
     * <p>
     * This method accepts a {@link Question} object from the request body and returns an {@link Answer} object.
     * <p>
     * The {@link PostMapping} annotation specifies that this method should handle POST requests,
     * and the {@code "/ask"} value defines the endpoint URL.
     * <p>
     * The {@link RequestBody} annotation tells Spring to deserialize the JSON from the request body
     * into a {@code Question} object.
     * </p>
     *
     * @param question The question submitted by the client, deserialized from the request body.
     * @return An {@link Answer} object containing the response from the OpenAI API.
     */
    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        // Use the OpenAIService to process the question and get an answer.
        return openAIService.getAnswer(question);
    }

    /**
     * Handles HTTP POST requests to the {@code /capital} endpoint.
     * <p>
     * This method accepts a {@link GetCapitalRequest} object containing a country name,
     * and returns a {@link GetCapitalResponse} object containing the capital city of that country.
     * <p>
     * Example of a request body:
     * <pre>
     * {
     *   "country": "France"
     * }
     * </pre>
     * </p>
     *
     * @param getCapitalRequest The request containing the country name, deserialized from the request body.
     * @return A {@link GetCapitalResponse} object containing the capital city.
     */
    @PostMapping("/capital")
    public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
        // Use the OpenAIService to get the capital city of the specified country.
        return openAIService.getCapital(getCapitalRequest);
    }

    /**
     * Handles HTTP POST requests to the {@code /capitalWithInfo} endpoint.
     * <p>
     * This method accepts a {@link GetCapitalRequest} object and returns an {@link Answer} object containing
     * detailed information about the capital city, such as its population, landmarks, and other interesting facts.
     * <p>
     * Example of a request body:
     * <pre>
     * {
     *   "country": "Japan"
     * }
     * </pre>
     * </p>
     *
     * @param getCapitalRequest The request containing the country name, deserialized from the request body.
     * @return An {@link Answer} object with detailed information about the capital city.
     */
    @PostMapping("/capitalWithInfo")
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
        // Use the OpenAIService to get detailed information about the capital city.
        return openAIService.getCapitalWithInfo(getCapitalRequest);
    }
}