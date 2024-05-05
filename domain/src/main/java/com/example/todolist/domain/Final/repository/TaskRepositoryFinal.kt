package com.example.todolist.domain.Final.repository

import com.example.todolist.domain.Final.models.TaskModelFinal

interface TaskRepositoryFinal {
    suspend fun getAllTasks(): List<TaskModelFinal>
    fun getTaskDetails(id : Int): TaskModelFinal
    fun upsertTask(taskModel: TaskModelFinal)
    //fun saveTask(taskModel: TaskModel_): Boolean
}