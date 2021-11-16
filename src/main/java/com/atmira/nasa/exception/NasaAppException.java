package com.atmira.nasa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NasaAppException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_ERROR ="ERROR";
	
	
	public NasaAppException(){
		super(DEFAULT_ERROR);
	}
	
	public NasaAppException(String error) {
		super (error);
	}
	
}
