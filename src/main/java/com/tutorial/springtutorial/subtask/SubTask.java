package com.tutorial.springtutorial.subtask;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tutorial.springtutorial.task.Task;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
@Table (name = "sub_task")
public class SubTask implements Serializable {

    private static final long serialVersionUID = -1785131699037567362L;

	@Id
	@GeneratedValue
    private Long id;
    
	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	@JsonBackReference
	private Task task;

	protected SubTask () {
	}

	public SubTask (String name, Task task) {
		this.name = name;
		this.task = task;
	}

	public String getName () {
		return this.name;
    }
    
    public Long getID () {
		return this.id;
	}

	public Task getTask () {
		return this.task;
	}
	
	public void setTask (Task task) {
		this.task = task;
	}
}