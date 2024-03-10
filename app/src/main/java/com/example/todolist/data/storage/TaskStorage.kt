package com.example.todolist.data.storage

import com.example.todolist.domain.models.TaskModel

interface TaskStorage {
    fun getAllTasks(): List<TaskEntity>
    fun getTaskDetails(): TaskEntity
    fun save(taskEntity: TaskEntity): Boolean

}