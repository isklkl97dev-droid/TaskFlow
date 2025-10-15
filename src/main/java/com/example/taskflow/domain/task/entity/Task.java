package com.example.taskflow.domain.task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity()
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    private String content;

    private LocalDate startDate;

    private LocalDate dueDate;

    public Task(
            String name,
            String title,
            String content,
            LocalDate startDate,
            LocalDate dueDate
            ) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }
}
