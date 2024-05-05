package com.example.todolist.domain.Final.usecase.TaskUseCase

import com.example.todolist.domain.Final.models.TaskModelFinal
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal

class DetailsTaskUseCase (private val taskRepository: TaskRepositoryFinal) {
    operator fun invoke(task: TaskModelFinal, id : Int): TaskModelFinal =
        taskRepository.getTaskDetails(id = id)

}