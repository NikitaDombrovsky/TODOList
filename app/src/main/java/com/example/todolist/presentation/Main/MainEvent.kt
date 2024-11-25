package com.example.todolist.presentation.Main

/*import com.example.roomkt.Contact
import com.example.roomkt.SortType*/

import com.example.todolist.core.UiEvent
import com.example.todolist.presentation.TaskPreview.TaskPreviewView
import java.time.LocalDateTime

sealed interface MainEvent: UiEvent {
    object Loading: MainEvent
    data class ShowAllTasks(val tasks: List<TaskPreviewView>): MainEvent
    //data class AddTask(val task: Tasks): MainEvent
    object ShowEmpty: MainEvent
    object UpsertTask: MainEvent
    //data class DeleteTaskEvent(val task: TaskEntityFinal) : MainEvent
    data class SetTitle(val title: String): MainEvent
    data class SetDateOfChange(val dateOfChange: LocalDateTime): MainEvent
    data class SortTask(val sortType: SortType): MainEvent
    // TODO Заглушка
    object ShowDialog: MainEvent
    object HideDialog: MainEvent


    //class Save(text: String): MainEvent
    //data object ShowTasksEvent: MainEvent
/*    data class ShowTasksEvent(
        val tasks: List<TaskModel>
    ): MainEvent*/
    //data object ShowEmptyEvent: MainEvent


}
