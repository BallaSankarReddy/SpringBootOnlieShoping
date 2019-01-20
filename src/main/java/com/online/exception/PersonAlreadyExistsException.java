package com.online.exception;

public class PersonAlreadyExistsException extends RuntimeException {
	
   	private static final long serialVersionUID = 3865839924764666727L;
	private final String username=null;

	public String getUsername() {
		return username;
	}

	public PersonAlreadyExistsException(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}