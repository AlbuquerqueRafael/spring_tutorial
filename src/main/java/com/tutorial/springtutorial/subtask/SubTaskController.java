package com.tutorial.springtutorial.subtask;

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
public class SubTaskController {
	
    @Autowired
    SubTaskService subTaskService;

    @RequestMapping(value = "/task/{id}/subtask", method = RequestMethod.GET)
	public List<SubTask> getAll (@PathVariable("id") Long id) {
		return subTaskService.getAllSubTasks(id);
    }
    
    @RequestMapping(value = "/task/{id}/subtask", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> save (@PathVariable("id") Long id, @RequestBody SubTask subTask) {
        Map<String, String> response = subTaskService.save(subTask, id);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/task/{idTask}/subtask", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, String>> update (@PathVariable("idTask") Long idTask, 
                                          @RequestBody SubTask task) {

        Map<String, String> response = subTaskService.update(idTask, task);

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }	
    
    @RequestMapping(value = "/task/{idTask}/subtask/{idSubTask}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, String>> delete (@PathVariable("idTask") Long idTask, 
                                          @PathVariable("idSubTask") Long idSubtask) {
        Map<String, String> response = subTaskService.delete(idTask, idSubtask);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}	
	
}