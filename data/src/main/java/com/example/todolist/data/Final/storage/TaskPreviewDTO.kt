package com.example.todolist.data.Final.storage

import com.example.todolist.domain.Final.models.TaskModelFinal

class TaskPreviewDTO (
    val id: Int,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val categoryId: Int,
){
    companion object{

    }
}
fun TaskPreviewDTO.toModel(): TaskModelFinal {
    return TaskModelFinal(id, title, deadline, changedAt,checkedStatus, categoryId)
}
fun TaskPreviewDTO.Companion.fromModel(taskModel: TaskModelFinal): TaskPreviewDTO {
    return TaskPreviewDTO(taskModel.id, taskModel.title,
        taskModel.deadline, taskModel.changedAt, taskModel.checkedStatus,
        taskModel.categoryId)
}