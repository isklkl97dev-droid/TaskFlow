package com.example.taskflow.domain.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TaskResponse {

    private String name;

    private String title;

    private String content;

    private LocalDate startDate;

    private LocalDate dueDate;
}
