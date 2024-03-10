package com.example.todolist.data.repository

import com.example.todolist.data.storage.TaskEntity
import com.example.todolist.data.storage.TaskStorage
import com.example.todolist.data.storage.fromModel
import com.example.todolist.data.storage.toModel
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskStorage: TaskStorage) : TaskRepository {
    override fun getAllTasks(): List<TaskModel> =
        taskStorage.getAllTasks().map { taskEntity -> taskEntity.toModel()}

    override fun getTaskDetails(): TaskModel=
        taskStorage.getTaskDetails().toModel()

    override fun saveTask(taskModel: TaskModel): Boolean =
        taskStorage.save(TaskEntity.fromModel(taskModel))

}