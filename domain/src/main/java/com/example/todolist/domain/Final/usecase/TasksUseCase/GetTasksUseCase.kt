package com.example.todolist.domain.Final.usecase.TasksUseCase

import com.example.todolist.domain.Final.models.TaskModel
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal


class GetTasksUseCase(private val taskRepository: TaskRepositoryFinal) {

    suspend operator fun invoke(): List<TaskModel> =
        taskRepository.getAllTasks()
}