package com.example.todolist.domain.usecase.TasksUseCase

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {

    operator fun invoke(): List<TaskModel> =
        taskRepository.getAllTasks()
}