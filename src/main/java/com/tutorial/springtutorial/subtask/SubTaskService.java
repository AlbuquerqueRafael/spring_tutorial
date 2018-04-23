package com.tutorial.springtutorial.subtask;

import java.util.List;
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

import com.tutorial.springtutorial.exceptions.SubTaskNotFoundException;
import com.tutorial.springtutorial.exceptions.TaskNotFoundException;
import com.tutorial.springtutorial.task.Task;
import com.tutorial.springtutorial.task.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubTaskService {

	@Autowired
	private TaskRepository taskRepository;
    
    @Autowired
    private SubTaskRepository subTaskRepository;
    
    private Map<String, String> response = new HashMap<String, String>();

    public List<SubTask> getAllSubTasks (Long id) {
        Optional<Task> optTask = taskRepository.findById(id);

        if (!optTask.isPresent()) {
            throw new TaskNotFoundException("Task don't exists");
        }

        Task task = optTask.get();
        
        return task.getSubTasks();
    }
    
	public Map<String, String> save (SubTask subTask, Long id){
        Optional<Task> optTask = taskRepository.findById(id);

        if (!optTask.isPresent()) {
            throw new TaskNotFoundException("Task don't exists");
        }

        Task task = optTask.get();
        subTask.setTask(task);
        
        subTaskRepository.save(subTask);

        response.put("response", "Subtask with name " + subTask.getName() + " was successfully persisted");
        return response;
    }
    
    public Map<String, String> update (Long idTask, SubTask subTask) {
        Optional<SubTask> optSubTask = subTaskRepository.getSubTaskFromTask(idTask, subTask.getID());
        
        if (!optSubTask.isPresent()) {
            throw new SubTaskNotFoundException("SubTask don't exists or is not connected with this task");
        }
        
        Optional<Task> task = taskRepository.findById(idTask);
        subTask.setTask(task.get());
        subTaskRepository.save(subTask);

        response.put("response", "Subtask with name " + subTask.getName() + " was successfully updated");
        return response;
    }
    
    public Map<String, String> delete (Long idTask, Long idSubTask){
        Optional<SubTask> optSubTask = subTaskRepository.getSubTaskFromTask(idTask, idSubTask);
        
        if (!optSubTask.isPresent()) {
            throw new SubTaskNotFoundException("SubTask don't exists or is not connected with this task");
        }

        subTaskRepository.deleteById(idSubTask);;
        response.put("response", "Subtask with name  was successfully deleted");
        return response;
    }

	
	
}