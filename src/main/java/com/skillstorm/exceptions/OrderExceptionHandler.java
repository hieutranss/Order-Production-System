package com.skillstorm.exceptions;

import org.jboss.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {

	private static final Logger log = Logger.getLogger(OrderExceptionHandler.class);

	/*
	 * Exception handler method when order is not found from an HttpRequest
	 */

	@ExceptionHandler(NoOrderFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<ErrorResponse> handleOrderNotFoundException(NoOrderFoundException exception) {
		log.error("Order not found", exception);
		return buildErrorResponse(exception, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(InvalidStageException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleInvalidStageException(InvalidStageException exception) {
		log.error("Expected stage not marked", exception);
		return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
	}

	/*
	 * BuildErrorResponse 3 arg constructor passed into a 4 arg constructor of same
	 * type
	 */
	private ResponseEntity<ErrorResponse> buildErrorResponse(Exception exception, HttpStatus httpStatus) {
		return buildErrorResponse(exception, exception.getMessage(), httpStatus);
	}

	/*
	 * BuildErrorResponse 4 arg constructor
	 */
	private ResponseEntity<ErrorResponse> buildErrorResponse(Exception exception, String message,
			HttpStatus httpStatus) {
		ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), exception.getMessage());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
