package com.tutorial.springtutorial.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tutorial.springtutorial.subtask.SubTask;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = -1785131699037567362L;

	@Id
	@GeneratedValue
    private Long id;
    
	@Column(nullable = false, unique = true)
	private String name;

    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<SubTask> subTasks;

	protected Task() {
	}

	public Task(String name, LocalDate date, List<SubTask> subTasks) {
        this.name = name;
        this.date = date;
        this.subTasks = subTasks;
	}

	public String getName() {
		return this.name;
    }
    
    public LocalDate getDate() {
		return this.date;
    }
    
    public Long getID() {
		return this.id;
    }
    
    public List<SubTask> getSubTasks() {
        return this.subTasks;
    }

}