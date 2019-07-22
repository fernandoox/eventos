package com.siete.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHanlder {
	
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		// 1. Crear payload que contiene detalles de la excepcion
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z")));
		// 2. Returt response entity
		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	}
}
