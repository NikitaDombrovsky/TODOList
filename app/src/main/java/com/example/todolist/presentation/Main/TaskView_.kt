package com.example.todolist.presentation.Main

import com.example.todolist.domain.models.TaskModel_

data class TaskView_(
    val id: Int,
    val title: String,
    val color: Long,
    //val dateOfChange: Date
){
    companion object { }



}

fun TaskView_.Companion.fromModel(taskModel: TaskModel_): TaskView_ {
    return TaskView_(taskModel.id, taskModel.title, taskModel.color)
}