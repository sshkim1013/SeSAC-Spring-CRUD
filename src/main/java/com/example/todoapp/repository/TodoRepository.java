package com.example.todoapp.repository;

import com.example.todoapp.entity.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByTitleContaining(String keyword);
    List<TodoEntity> findByCompleted(boolean completed);
    void deleteByCompleted(boolean completed);
}
