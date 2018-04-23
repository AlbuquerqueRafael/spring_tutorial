package com.tutorial.springtutorial.subtask;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {


    @Query(value = "select id, name from (select * from task_sub_tasks as tst" + 
                   " where tst.task_id = ?1 and  tst.sub_tasks_id = ?2) as rest, sub_task as sub" +
                   " where sub.id = ?2", nativeQuery = true)
    Optional<SubTask> getSubTaskFromTask(Long idTask, Long idSubTask);

    @Query(value = "delete from task_sub_tasks as tst where tst.sub_tasks_id = ?1", nativeQuery = true)
    void deleteSubTask(Long idSubTask);
}