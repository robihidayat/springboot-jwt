package com.robihidayat.simpleauth.repository;

import com.robihidayat.simpleauth.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long id);
}
