package com.example.taskflow.domain.task.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TaskRequest {

    private String title;

    private String content;

    private LocalDate startDate;

    private LocalDate dueDate;
}
