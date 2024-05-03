package com.example.todolist.domain.Final.models


class TaskFinalModel (
    val id: Int,
    val text: String,
    val title: String,
    val deadline: Int,
    val changeAt: Int,
    val checkedStatus: Boolean,
    val categoryId: Int,
){

}

// TODO "Просрочено такого-то числа"
/*enum class DeadlineStatus{
    Overdue,
    Current
}*/

data class TaskPreviewModel(
    val id: Int,
    val title: String,
    val deadline: Int,
    val changeAt: Int,
    val checkedStatus: Boolean,
    val categoryId: Int,
){

}
