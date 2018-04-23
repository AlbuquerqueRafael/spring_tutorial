package com.tutorial.springtutorial.task;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class TaskController {
	
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task", method = RequestMethod.GET)
	public List<Task> getAll () {
		return taskService.getAll();
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> save (@RequestBody Task task) {
        Map<String, String> response = taskService.save(task);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, String>> update (@RequestBody Task task) {
        Map<String, String> response = taskService.save(task);

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }	
    
    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, String>> delete (@PathVariable("id") Long id) {
        Map<String, String> response = taskService.delete(id);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}	
	
}