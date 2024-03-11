package com.example.todolist.data.storage

import com.example.todolist.domain.models.TaskModel


data class TaskEntity(val id: Int,val text: String, val title: String, val color: Long){
/*    fun toModel(): TaskModel{
        return TaskModel(id, text, title, color)
    }*/
    companion object { }
/*        fun fromModel(taskModel: TaskModel): TaskEntity{
            return TaskEntity(taskModel.id, taskModel.text, taskModel.title, taskModel.color)
        }*/


}
fun TaskEntity.toModel(): TaskModel{
    return TaskModel(id, text, title, color)
}
fun TaskEntity.Companion.fromModel(taskModel: TaskModel): TaskEntity {
    return TaskEntity(taskModel.id, taskModel.text, taskModel.title, taskModel.color)
}