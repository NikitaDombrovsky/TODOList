package com.example.todolist.domain.repository

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_

interface TaskRepository {
    fun getAllTasks(): List<TaskModel_>
    fun getTaskDetails(id : Int): TaskModel_
    fun upsertTask(taskModel: TaskModel_)
    //fun saveTask(taskModel: TaskModel_): Boolean
}