package com.coherentsolutions.springaiintro.services;

import com.coherentsolutions.springaiintro.model.Answer;
import com.coherentsolutions.springaiintro.model.GetCapitalRequest;
import com.coherentsolutions.springaiintro.model.GetCapitalResponse;
import com.coherentsolutions.springaiintro.model.Question;

/**
 * The {@code OpenAIService} interface defines the contract for interacting with the OpenAI API.
 * <p>
 * It provides methods for processing general questions, retrieving capital city information,
 * and getting detailed information about capitals. Implementing classes must define the logic
 * for these methods, which might include making HTTP requests to OpenAI's API and formatting responses.
 * </p>
 */
public interface OpenAIService {

    /**
     * Processes a {@link Question} object and retrieves an {@link Answer}.
     * <p>
     * This method takes a structured question object as input and returns an answer object
     * containing the response from the OpenAI API.
     * </p>
     *
     * @param question A structured question provided by the client.
     * @return An {@link Answer} object containing the response to the question.
     */
    Answer getAnswer(Question question);

    /**
     * Processes a question provided as a plain {@link String} and retrieves the answer as a {@link String}.
     * <p>
     * This method is useful when the client provides a simple text question without additional metadata.
     * </p>
     *
     * @param question A plain text question provided by the client.
     * @return The answer as a plain text {@link String}.
     */
    String getAnswer(String question);

    /**
     * Retrieves the capital city of a specified country.
     * <p>
     * This method takes a {@link GetCapitalRequest} object, which contains the name of a country,
     * and returns a {@link GetCapitalResponse} containing the name of the capital city.
     * </p>
     *
     * @param getCapitalRequest A request object containing the name of the country.
     * @return A {@link GetCapitalResponse} object containing the name of the capital city.
     */
    GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

    /**
     * Retrieves detailed information about the capital city of a specified country.
     * <p>
     * This method takes a {@link GetCapitalRequest} object, which contains the name of a country,
     * and returns an {@link Answer} object with detailed information about the country's capital city,
     * such as population, landmarks, or historical facts.
     * </p>
     *
     * @param getCapitalRequest A request object containing the name of the country.
     * @return An {@link Answer} object with detailed information about the capital city.
     */
    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}