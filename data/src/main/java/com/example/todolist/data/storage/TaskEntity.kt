package com.example.todolist.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.domain.models.TaskModel


data class TaskEntity(val id: Int,val text: String, val title: String, val color: Long){
    // Date TimeOfChange Calendar
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

