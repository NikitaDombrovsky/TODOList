package com.example.todolist.data.storage

interface TaskStorage {
    fun getAllTasks(): List<TaskEntity>
    fun getTaskDetails(): TaskEntity
    fun save(taskEntity: TaskEntity): Boolean

}