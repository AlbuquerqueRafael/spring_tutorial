package com.tutorial.springtutorial.subtask;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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


	protected SubTask() {
	}

	public SubTask(String name) {
        this.name = name;
	}

	public String getName() {
		return this.name;
    }
    
    public Long getID() {
		return this.id;
	}
	
}