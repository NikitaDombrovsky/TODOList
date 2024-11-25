package com.example.todolist.presentation.Main

import com.example.todolist.core.UiState
import com.example.todolist.presentation.TaskPreview.TaskPreviewView



/*sealed class MainUIState {
    data object Loading: MainUIState()
    data class Tasks(
       // val tasksList: List<TaskModel_> //TaskViewModel
        val tasksList: List<TaskPreviewView> //TaskViewModel
    ) : MainUIState()
    data object Empty: MainUIState()
    val sortType: SortType = SortType.DataOfChange
    //data class Search(): MainUIState()

}*/
sealed interface MainUIState : UiState {
    data object Loading: MainUIState
    data class Tasks(
        // val tasksList: List<TaskModel_> //TaskViewModel
        val tasksList: List<TaskPreviewView> //TaskViewModel
    ) : MainUIState
    data object Empty: MainUIState
    //val sortType: SortType = SortType.DataOfChange
}