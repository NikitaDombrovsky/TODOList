package com.example.todolist.data.Final.repositoty

import com.example.todolist.data.Final.storage.TaskFinal.TaskDaoFinal
import com.example.todolist.data.Final.storage.TaskFinal.toModel
import com.example.todolist.data.Final.storage.toModel
import com.example.todolist.domain.Final.models.TaskModelFinal
import com.example.todolist.domain.Final.repository.TaskRepositoryFinal
import com.example.todolist.domain.models.TaskModel_
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImplFinal(private val taskStorage: TaskDaoFinal): TaskRepositoryFinal {
    override suspend fun getAllTasks(): List<TaskModelFinal> {
        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }
    }

    override fun getTaskDetails(id: Int): TaskModelFinal {
        TODO("Not yet implemented")
    }

    override fun upsertTask(taskModel: TaskModelFinal) {
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