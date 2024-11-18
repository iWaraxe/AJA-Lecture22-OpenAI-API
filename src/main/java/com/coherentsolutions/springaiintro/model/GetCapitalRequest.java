package com.coherentsolutions.springaiintro.model;

/**
 * The {@code GetCapitalRequest} record represents a request to retrieve the capital city of a specified state or country.
 * <p>
 * This class encapsulates the input provided by the user, specifically the name of a state or country, and is used as part
 * of the request handling process in the application.
 * </p>
 *
 * <p><strong>Example:</strong> A sample JSON request:
 * <pre>
 * {
 *   "stateOrCountry": "France"
 * }
 * </pre>
 * </p>
 *
 * @param stateOrCountry The name of the state or country for which the capital city is requested.
 */
public record GetCapitalRequest(String stateOrCountry) {
}