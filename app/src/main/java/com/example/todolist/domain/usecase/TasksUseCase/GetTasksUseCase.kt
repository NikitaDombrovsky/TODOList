package com.example.todolist.domain.usecase.TasksUseCase

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {

    operator fun invoke(): List<TaskModel> =
        taskRepository.getAllTasks()
/*        listOf(
            TaskModel("Бебра","1",0xFFD0BCFF),
            TaskModel("Бебра1","2",0xFF6650a4),
            TaskModel("Бебра2","3",0xFFD0BCFF)
        )*/

/*    public fun execute(): List<Task>{

        return TODO("Provide the return value")
    }*/
}