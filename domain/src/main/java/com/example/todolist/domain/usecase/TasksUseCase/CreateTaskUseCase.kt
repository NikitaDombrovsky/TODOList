package com.example.todolist.domain.usecase.TasksUseCase

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class CreateTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: TaskModel): Boolean =
        taskRepository.saveTask(task)

}