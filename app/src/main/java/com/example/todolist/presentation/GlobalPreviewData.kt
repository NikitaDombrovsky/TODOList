package com.example.todolist.presentation

import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.Main.TaskView_

fun getPreviewData(): List<TaskView_> {
    val testList: List<TaskView_> = listOf(
        TaskView_(2, "0", 0xFFD0BCFF),
        TaskView_(0, "0", 0x1),
        TaskView_(1, "0", 0xFFD0BCFF),
        TaskView_(3, "0", 0x1),
        TaskView_(4, "0", 0x1)
    ).sortedBy {
        // TODO Для разных режимов сортировки
        it.title
    }
    return testList
}
/*
class GlobalPreviewData {

}*/
