package com.example.todoapp.repository;

import com.example.todoapp.dto.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepository {

    private static final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    // 저장
    public TodoDto save(TodoDto todo) {
        if (todo.getId() == null) {
            todo.setId(nextId++);
        }
        storage.put(todo.getId(), todo);
        return todo;
    }

    // 저장소(storage)에 담긴 모든 값(values)을 리스트 형태로 반환.
    public List<TodoDto> findAll() {
        return new ArrayList<>(storage.values());
    }

    // 특정 ID로 찾기
    public Optional<TodoDto> findById(Long id) {
        // return storage.get(id);

        // storage.get(id)의 값이 null일 수도 있다.
        return Optional.ofNullable(storage.get(id));
    }

    // 특정 ID로 찾아서 삭제
    public void deleteById(Long id) {
        storage.remove(id);
    }
}
