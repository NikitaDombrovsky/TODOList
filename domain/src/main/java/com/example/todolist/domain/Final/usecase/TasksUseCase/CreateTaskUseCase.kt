package com.example.todolist.domain.Final.usecase.TasksUseCase

import com.example.todolist.domain.Final.models.TaskModel
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal

class CreateTaskUseCase (private val taskRepository: TaskRepositoryFinal) {
    operator fun invoke(task: TaskModel) =
        taskRepository.upsertTask(task)

}