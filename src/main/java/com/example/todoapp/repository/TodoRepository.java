package com.example.todoapp.repository;

import com.example.todoapp.dto.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepository {

    private static final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    // 저장
    public TodoDto save(TodoDto todo) {
        todo.setId(nextId++);   // id 설정
        storage.put(todo.getId(), todo);
        return todo;
    }

    // 저장소(storage)에 담긴 모든 값(values)을 리스트 형태로 반환.
    public List<TodoDto> findAll() {
        return new ArrayList<>(storage.values());
    }

    // 특정 ID로 찾기
    public TodoDto findById(Long id) {
        return storage.get(id);
    }


}
