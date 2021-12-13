package com.skillstorm.exceptions;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private int status;
	private String message;
	private String stackTrace;
	private List<ValidationError> errors;

	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorResponse(String stackTrace, List<ValidationError> errors) {
		super();
		this.stackTrace = stackTrace;
		this.errors = errors;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	private static class ValidationError {

		public ValidationError(String field, String message) {
			this.field = field;
			this.message = message;
		}

		private final String field;
		private final String message;
	}

	public void addValidationError(String field, String message) {
		if (Objects.isNull(errors)) {
			errors = new ArrayList<>();
		}
		errors.add(new ValidationError(field, message));
	}
}
