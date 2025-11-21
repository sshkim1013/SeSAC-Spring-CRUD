package com.example.todoapp;

import com.example.todoapp.entity.TodoEntity;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }

    // 스프링 서비 실행 시, 아래 데이터 자동 생성.
    @Bean
    public CommandLineRunner init(TodoRepository todoRepository) {
        return args -> {
            todoRepository.save(new TodoEntity("Study", "Spring", false));
            todoRepository.save(new TodoEntity("Cook", "Sushi", true));
            todoRepository.save(new TodoEntity("Meet", "Girlfriend", false));
        };
    }

}
