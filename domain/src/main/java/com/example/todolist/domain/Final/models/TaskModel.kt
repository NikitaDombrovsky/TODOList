package com.example.todolist.domain.Final.models


class TaskModel (
    val id: Int,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val colorOfCategory: Long,
    //val categoryId: Int,
){

}

// TODO "Просрочено такого-то числа"
/*enum class DeadlineStatus{
    Overdue,
    Current
}*/

