package com.example.todolist.presentation.Main


//import com.example.todolist.domain.models.TaskView_

/*data class MainState (
    //val saveResult: Boolean,
   // val id: Int,
    //val text: String,
    val title: String,
    val color: Long)*/

sealed class MainUIState {
    data object Loading: MainUIState()
    data class Tasks(
       // val tasksList: List<TaskModel_> //TaskViewModel
        val tasksList: List<TaskViewFinal> //TaskViewModel
    ) : MainUIState()
    data object Empty: MainUIState()
    val sortType: SortType = SortType.DataOfChange
    //data class Search(): MainUIState()

}