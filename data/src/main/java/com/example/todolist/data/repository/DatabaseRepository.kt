package com.example.todolist.data.repository

import com.example.todolist.data.storage.Task.TaskDao
import com.example.todolist.data.storage.Task.TaskEntity_

class DatabaseRepository (private val dao: TaskDao) {

    suspend fun upsertTask(note: TaskEntity_) = dao.upsertTask(note)
    fun getAllTasks() = dao.getAllTasks()

}