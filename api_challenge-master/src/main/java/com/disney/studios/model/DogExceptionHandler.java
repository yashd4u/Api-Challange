package com.disney.studios.model;

public class DogExceptionHandler extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DogExceptionHandler(Throwable cause) {
		super(cause);
	}

	public DogExceptionHandler(String msg) {
		super(msg);
	}
}
