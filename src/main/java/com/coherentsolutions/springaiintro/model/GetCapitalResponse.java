package com.coherentsolutions.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * The {@code GetCapitalResponse} record represents the response containing the name of a capital city.
 * <p>
 * This class uses the {@link com.fasterxml.jackson.annotation.JsonPropertyDescription @JsonPropertyDescription}
 * annotation to provide additional metadata for JSON serialization. This metadata can help generate
 * documentation or clarify the purpose of the fields in the JSON response.
 * </p>
 *
 * <p><strong>Example:</strong> A sample JSON response:
 * <pre>
 * {
 *   "answer": "Paris"
 * }
 * </pre>
 * </p>
 *
 * @param answer The name of the capital city.
 */
public record GetCapitalResponse(
        @JsonPropertyDescription("This is the city name") String answer
) {
}