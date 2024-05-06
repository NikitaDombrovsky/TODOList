package com.example.todolist.data.Final.repositoty

import com.example.todolist.data.Final.storage.TaskFinal.TaskDao

class DatabaseRepository(private val dao: TaskDao){
   // suspend fun addTask(note: TaskEntity) = dao.addTask(note)
    suspend fun getAllTasks() = dao.getAllTasks()
}