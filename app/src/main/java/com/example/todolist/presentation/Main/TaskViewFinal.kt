package com.example.todolist.presentation.Main

import com.example.todolist.data.Final.storage.TaskDetailsDTO

class TaskViewFinal(
    val id: Int,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val colorOfCategory: Long,
) {
    companion object { }
}
fun TaskViewFinal.Companion.fromModel(taskModel: TaskDetailsDTO): TaskViewFinal {
    return TaskViewFinal(taskModel.id, taskModel.title, taskModel.deadline, taskModel.changedAt,
        taskModel.checkedStatus, taskModel.colorOfCategory)
}
