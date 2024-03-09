package com.example.todolist.domain.repository


import com.example.todolist.domain.models.TaskModel

interface TaskRepository {
    fun getAllTasks(): List<TaskModel>
    fun getTaskDetails(): TaskModel
    fun saveTask(taskModel: TaskModel): Boolean
}