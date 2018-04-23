package com.tutorial.springtutorial.task;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import com.tutorial.springtutorial.exceptions.TaskNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
    private Map<String, String> response = new HashMap<String, String>();
    
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
    
	public Map<String, String> save (Task task){
        taskRepository.save(task);

        response.put("response", "Task with name " + task.getName() + " was successfully persisted");
        return response;
    }
    
    public  Map<String, String> update (Task task) {
        Optional<Task> optTask = taskRepository.findById(task.getID());

        if (!optTask.isPresent()) {
            throw new TaskNotFoundException("Task don't exists");
        }

        taskRepository.save(task);

        response.put("response", "Task with name " + task.getName() + " was successfully updated");
        return response;
    }
	
	public Map<String, String> delete(Long id){
        Optional<Task> optTask = taskRepository.findById(id);
  
        if (!optTask.isPresent()) {
            throw new TaskNotFoundException("Task don't exists");
        }

        Task task = optTask.get();
        taskRepository.delete(task);

        response.put("response", "Task with name " + task.getName() + " was successfully deleted");
		return response;
	}
	
	
	
}