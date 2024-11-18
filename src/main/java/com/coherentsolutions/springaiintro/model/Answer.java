package com.coherentsolutions.springaiintro.model;

/**
 * The {@code Answer} record represents a simple response containing an answer as a string.
 * <p>
 * This class is designed to encapsulate any general-purpose answer returned by the application,
 * whether it is the result of a question, a fact about a country, or detailed information about a capital city.
 * </p>
 *
 * <p><strong>Example:</strong> A sample JSON response:
 * <pre>
 * {
 *   "answer": "The capital of France is Paris."
 * }
 * </pre>
 * </p>
 *
 * @param answer The textual answer returned by the service.
 */
public record Answer(String answer) {
}