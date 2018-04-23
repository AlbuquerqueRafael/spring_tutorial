package com.tutorial.springtutorial.exceptions;

public class SubTaskNotFoundException extends NullPointerException{
	private static final long serialVersionUID = -2378608358166304438L;

	public SubTaskNotFoundException(String message) {
	     super(message);
	}
}