package com.rajeev.exception;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	// General error message about nature of error
	@JsonProperty("message")
	private String message;

	// Specific errors in API request processing
	@JsonProperty("details")
	private List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	// Getter and setters
}