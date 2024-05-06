package com.example.todolist.data.Final.repositoty

import com.example.todolist.data.Final.storage.TaskFinal.TaskDao
import com.example.todolist.data.Final.storage.toModel
import com.example.todolist.domain.Final.models.TaskModel
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal

class TaskRepositoryImpl(private val taskStorage: TaskDao): TaskRepositoryFinal {
    override suspend fun getAllTasks(): List<TaskModel> {
        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }
    }

    override fun getTaskDetails(id: Int): TaskModel {
        TODO("Not yet implemented")
    }

    override fun upsertTask(taskModel: TaskModel) {
        TODO("Not yet implemented")
    }
/*    override fun getAllTasks(): List<TaskModel_> =
        taskStorage.getAllTasks().map { taskEntity -> taskEntity.toModel()}

    override fun getTaskDetails(id :Int): TaskModel_ =
        taskStorage.getTaskDetails(id).toModel()

    override fun upsertTask(taskModel: TaskModel_) {
        taskStorage.upsertTask(TaskEntity_.fromModel(taskModel))
    }

    *//*    override fun saveTask(taskModel: TaskModel_): Boolean =
            taskStorage.save(TaskEntity.fromModel(taskModel))*/

}