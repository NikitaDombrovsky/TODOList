package com.example.todolist.data.repository

import com.example.todolist.data.storage.Task.TaskDao
import com.example.todolist.data.storage.Task.TaskEntity_
import com.example.todolist.data.storage.Task.fromModel
import com.example.todolist.data.storage.Task.toModel
import com.example.todolist.data.storage.TaskEntity
import com.example.todolist.data.storage.fromModel
import com.example.todolist.data.storage.toModel
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class TaskRepositoryImpl(private val taskStorage: TaskDao) : TaskRepository {
    override fun getAllTasks(): List<TaskModel_> =
        taskStorage.getAllTasks().map { taskEntity -> taskEntity.toModel()}

    override fun getTaskDetails(id :Int): TaskModel_=
        taskStorage.getTaskDetails(id).toModel()

    override fun upsertTask(taskModel: TaskModel_) {
        taskStorage.upsertTask(TaskEntity_.fromModel(taskModel))
    }

    /*    override fun saveTask(taskModel: TaskModel_): Boolean =
            taskStorage.save(TaskEntity.fromModel(taskModel))*/

}


