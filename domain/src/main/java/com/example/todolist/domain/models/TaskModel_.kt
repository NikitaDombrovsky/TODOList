package com.example.todolist.domain.models

import java.time.LocalDateTime
import java.util.Date

class TaskModel_ (
    val id: Int,
    val text: String,
    val title: String,
    val color: Long,
    //val dateOfChange: Date
){

}

/*
data class Category(val idCategory: Int, val name: String, val color: Long, val iconPath: String){

} //TODO подумать
data class TaskPreviewModel(val id: Int, val title: String, val color: Long){

}*/
data class TaskView_(
    val id: Int,
    val title: String,
    val color: Long,
    //val dateOfChange: Date
){
    companion object { }



}

fun TaskView.Companion.fromModel(taskModel: TaskModel_): TaskView_ {
    return TaskView_(taskModel.id, taskModel.title, taskModel.color)
}