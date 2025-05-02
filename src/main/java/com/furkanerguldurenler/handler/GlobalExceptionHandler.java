package com.furkanerguldurenler.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.furkanerguldurenler.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { BaseException.class })
	public ResponseEntity<ApiError> handleBaseException(BaseException exception) {

		return ResponseEntity.badRequest().body(createApiError(exception.getMessage()));
	}

	public <E> ApiError<E> createApiError(E message) {
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		Exception<E> exception = new Exception<>();
		exception.setCreateTime(new Date());
		exception.setMessage(message);
		apiError.setException(exception);

		return apiError;
	}
}
