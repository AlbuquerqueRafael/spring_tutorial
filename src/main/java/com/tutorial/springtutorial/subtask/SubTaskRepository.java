package com.tutorial.springtutorial.subtask;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {


    @Query(value = "select * from sub_task as sub where sub.task_id =  ?1 and sub.id = ?2", nativeQuery = true)
    Optional<SubTask> getSubTaskFromTask(Long idTask, Long idSubTask);

}