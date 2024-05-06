package com.example.todolist.data.Final.storage

import com.example.todolist.domain.Final.models.TaskModel

class TaskPreviewDTO (
    val id: Int,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val colorOfCategory: Long,
    //val categoryId: Int,
){
    companion object{

    }
}
fun TaskPreviewDTO.toModel(): TaskModel {
    return TaskModel(id, title, deadline, changedAt,checkedStatus, colorOfCategory)
}
fun TaskPreviewDTO.Companion.fromModel(taskModel: TaskModel): TaskPreviewDTO {
    return TaskPreviewDTO(taskModel.id, taskModel.title,
        taskModel.deadline, taskModel.changedAt, taskModel.checkedStatus,
        taskModel.colorOfCategory)
}