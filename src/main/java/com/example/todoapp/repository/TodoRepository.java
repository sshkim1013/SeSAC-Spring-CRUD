package com.example.todoapp.repository;

import com.example.todoapp.dto.TodoDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TodoRepository {

    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    // 저장
    public TodoDto save(TodoDto todo) {
        todo.setId(nextId++);   // id 설정
        storage.put(todo.getId(), todo);
        return todo;
    }


}
