package com.company.exceptions;

public class NoSuchClientException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoSuchClientException() {
		super();
	}
	
	public NoSuchClientException(String errors) {
		super(errors);
	}
}
