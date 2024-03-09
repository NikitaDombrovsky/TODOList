package com.example.todolist.domain.usecase.TaskUseCase

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class DetailsTaskUseCase (private val taskRepository: TaskRepository) {
    operator fun invoke(task: TaskModel): TaskModel =
        taskRepository.getTaskDetails()

}