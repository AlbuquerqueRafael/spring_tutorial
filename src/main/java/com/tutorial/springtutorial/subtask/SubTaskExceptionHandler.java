package com.tutorial.springtutorial.subtask;

import java.util.HashMap;
import java.util.Map;

import com.tutorial.springtutorial.exceptions.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SubTaskExceptionHandler {
    private Map<String, String> response = new HashMap<String, String>();


    @ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleTaskNotFound(TaskNotFoundException e) {
		return mountNotFoundRequestException(e.getMessage());
    }

    @ExceptionHandler(SubTaskNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleSubTaskNotFound(TaskNotFoundException e) {
		return mountNotFoundRequestException(e.getMessage());
    }
    
    private ResponseEntity<Map<String, String>> mountNotFoundRequestException(String errorMessage){
		response.put("error", errorMessage);
		
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
	}
}