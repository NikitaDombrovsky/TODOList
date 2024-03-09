package com.example.todolist.domain.usecase.TasksUseCase

import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class CreateTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: TaskModel): Boolean =
/*        val test = taskRepository.getTaskDetails()
        if (test.text == task.text){
            return true
        }*/
        taskRepository.saveTask(task)






/*        if(task.text.isEmpty()) {
            false
        } else {
            true
        }*/



}