package com.example.todolist.domain.models


class TaskFinalModel (
    val id: Int,
    val text: String,
    val title: String,
    val deadline: Int,
    val changeAt: Int,
    val checkedStatus: Boolean,
    val categoryId: Int,
    val deadlineStatus: DeadlineStatus
    //
    // TODO "Просрочено такого-то числа"
){

}

enum class DeadlineStatus{
    Overdue,
    Current
}

/*
}
//TODO подумать
data class TaskPreviewModel(val id: Int, val title: String, val color: Long){

}*/
/*
TODO А как это вообще ложится в систему?
data class TaskView_(
    val id: Int,
    val title: String,
    val color: Long,
    //val dateOfChange: Date
){
    companion object { }



}

fun TaskView_.Companion.fromModel(taskModel: TaskModel_): TaskView_ {
    return TaskView_(taskModel.id, taskModel.title, taskModel.color)
}*/
