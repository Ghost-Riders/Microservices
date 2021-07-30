package com.Demo.Microservices.customException;

public class UniversityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UniversityNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UniversityNotFoundException(String arg0) {
		super(arg0);
	}

	public UniversityNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
