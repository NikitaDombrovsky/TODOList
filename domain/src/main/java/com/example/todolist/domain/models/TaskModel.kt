package com.example.todolist.domain.models

data class TaskModel(val id: Int,val text: String, val title: String, val color: Long){

}

/*
data class Category(val idCategory: Int, val name: String, val color: Long, val iconPath: String){

} //TODO подумать
data class TaskPreviewModel(val id: Int, val title: String, val color: Long){

}*/
data class TaskView(val id: Int, val title: String, val color: Long){
    companion object { }



}

fun TaskView.Companion.fromModel(taskModel: TaskModel): TaskView {
    return TaskView(taskModel.id, taskModel.title, taskModel.color)
}