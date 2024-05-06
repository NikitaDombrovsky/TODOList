package com.example.todolist.domain.Final.models

data class TaskDetailsModel(
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

}
