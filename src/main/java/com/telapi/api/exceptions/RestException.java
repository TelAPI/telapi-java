package com.telapi.api.exceptions;

public class RestException extends Exception {

	private static final long serialVersionUID = 5073589867334585047L;
	
	public RestException(String message) {
		super(message);
	}
	
	public RestException(String message, Throwable cause) {
		super(message, cause);
	}

}
