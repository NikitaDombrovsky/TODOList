package com.example.todolist.presentation.Main

import com.example.roomkt.Contact
import com.example.roomkt.SortType
import com.example.todolist.data.storage.Task.TaskEntity_
import com.example.todolist.domain.models.TaskModel
import java.time.LocalDateTime

sealed interface MainEvent {
    object ShowAllTasksEvent: MainEvent
    object ShowEmptyEvent: MainEvent
    object UpsertTaskEvent: MainEvent
    data class DeleteTaskEvent(val task: TaskEntity_) : MainEvent
    data class SetTitleEvent(val title: String): MainEvent
    data class SetDateOfChangeEvent(val dateOfChange: LocalDateTime): MainEvent
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
