package com.example.todolist.presentation.TaskPreview

import com.example.todolist.data.Final.storage.TaskPreviewDTO

class TaskPreviewView(
    val id: Int,
    val title: String,
    val deadline: Int,
    val changedAt: Int,
    val checkedStatus: Boolean,
    val colorOfCategory: Long,
) {
    companion object { }
}
