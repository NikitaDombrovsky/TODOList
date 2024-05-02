package com.example.todolist.data.storage.Task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.data.storage.TaskEntity
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_
import java.time.LocalDateTime
import java.util.Date

@Entity
data class TaskEntity_(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="text")
    val text: String,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="color")
    val color: Long,//TODO
    //val dateOfChange: Date
){
    companion object { }
}
fun TaskEntity_.toModel(): TaskModel_ {
    return TaskModel_(id, text, title, color)
}
fun TaskEntity_.Companion.fromModel(taskModel: TaskModel_): TaskEntity_ {
    return TaskEntity_(taskModel.id, taskModel.text, taskModel.title, taskModel.color)
}

