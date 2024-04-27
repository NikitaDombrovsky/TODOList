package com.example.todolist.domain.usecase

import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.domain.repository.TaskRepository

class GetTasksUseCase_ (private val taskRepository: TaskRepository) {

    operator fun invoke(): List<TaskModel_> =
        taskRepository.getAllTasks()
}