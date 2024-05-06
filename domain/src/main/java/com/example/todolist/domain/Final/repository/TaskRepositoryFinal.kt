package com.example.todolist.domain.Final.repository

import com.example.todolist.domain.Final.models.TaskModel

interface TaskRepositoryFinal {
    suspend fun getAllTasks(): List<TaskModel>
    fun getTaskDetails(id : Int): TaskModel
    fun upsertTask(taskModel: TaskModel)
    //fun saveTask(taskModel: TaskModel_): Boolean
}