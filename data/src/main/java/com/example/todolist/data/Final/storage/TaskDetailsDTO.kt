package com.example.todolist.data.Final.storage

import com.example.todolist.domain.Final.models.TaskDetailsModel
import com.example.todolist.domain.Final.models.TaskModelFinal


class TaskDetailsDTO(
    val id: Int,
    val text: String,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val categoryId: Int,
    val nameOfCategory: String,
    val colorOfCategory: Long,
    val textColor: Long,
    val secondColor: Long,
    val thirdColor: Long,
){
    companion object { }
}
fun TaskDetailsDTO.toModel(): TaskModelFinal {
    //return TaskGettingDTO(id, text, title, deadline, changedAt,checkedStatus, categoryId, nameOfCategory, colorOfCategory, textColor, secondColor, thirdColor)
    return TaskModelFinal(id, text, deadline, changedAt,checkedStatus, categoryId)
}
fun TaskDetailsDTO.Companion.fromModel(taskModel: TaskDetailsModel): TaskDetailsDTO {
    return TaskDetailsDTO(taskModel.id, taskModel.text, taskModel.title ,taskModel.deadline,
        taskModel.changedAt, taskModel.checkedStatus, taskModel.categoryId, taskModel.nameOfCategory,
        taskModel.textColor, taskModel.textColor, taskModel.secondColor, taskModel.thirdColor)
}