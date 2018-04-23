package com.tutorial.springtutorial.exceptions;

public class TaskNotFoundException extends NullPointerException{
	private static final long serialVersionUID = -2378608358166304438L;

	public TaskNotFoundException(String message) {
	     super(message);
	}
}