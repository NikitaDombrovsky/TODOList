package com.example.todolist.domain.Final.usecase.TaskUseCase

import com.example.todolist.domain.Final.models.TaskModel
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal

class DetailsTaskUseCase (private val taskRepository: TaskRepositoryFinal) {
    operator fun invoke(task: TaskModel, id : Int): TaskModel =
        taskRepository.getTaskDetails(id = id)

}