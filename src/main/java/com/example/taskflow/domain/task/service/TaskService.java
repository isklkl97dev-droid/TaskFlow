package com.example.taskflow.domain.task.service;

import com.example.taskflow.domain.task.dto.TaskRequest;
import com.example.taskflow.domain.task.dto.TaskResponse;
import com.example.taskflow.domain.task.entity.Task;
import com.example.taskflow.domain.task.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskResponse create(TaskRequest request) {

        String tempname = "temp"; // todo: 추후 사용자 정보 바탕으로 이름 추출

        Task newTask = new Task(tempname, request.getTitle()
                , request.getContent(), request.getStartDate(), request.getDueDate());

        Task saveTask = taskRepository.save(newTask);

        return new TaskResponse(saveTask.getName(), saveTask.getTitle()
                , saveTask.getContent(), saveTask.getStartDate(), saveTask.getDueDate());
    }
}
