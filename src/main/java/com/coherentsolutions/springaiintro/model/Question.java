package com.coherentsolutions.springaiintro.model;

/**
 * The {@code Question} record represents a user's query in the form of a text question.
 * <p>
 * This class is used as a data structure to encapsulate the input provided by the user,
 * typically when asking a general question via the API.
 * </p>
 *
 * <p><strong>Example:</strong> A sample JSON request:
 * <pre>
 * {
 *   "question": "What is the capital of France?"
 * }
 * </pre>
 * </p>
 *
 * @param question The text of the question submitted by the user.
 */
public record Question(String question) {
}