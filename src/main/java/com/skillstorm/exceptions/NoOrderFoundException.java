package com.skillstorm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoOrderFoundException extends ResponseStatusException {

	public NoOrderFoundException(String message) {
		super(HttpStatus.NO_CONTENT, message);
	}
}
