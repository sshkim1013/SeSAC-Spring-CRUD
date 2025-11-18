package com.example.todoapp;

import com.example.todoapp.dto.TodoDto;
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
            todoRepository.save(new TodoDto(null, "Study", "Spring", false));
            todoRepository.save(new TodoDto(null, "Cook", "Sushi", false));
            todoRepository.save(new TodoDto(null, "Meet", "Girlfriend", false));
        };
    }

}
