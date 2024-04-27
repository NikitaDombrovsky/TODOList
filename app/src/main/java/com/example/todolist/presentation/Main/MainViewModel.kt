package com.example.todolist.presentation.Main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todolist.data.storage.toModel
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.usecase.GetTasksUseCase_
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel(
    private val getTasksUseCase: GetTasksUseCase_
): ViewModel() {
    private val _state : MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Loading)
    val state = _state.asStateFlow()

/*    private val mutableTasks = MutableStateFlow(listOf<TaskModel>())
    val tasks = mutableTasks.asStateFlow()*/

    //private val mutableTasks_ = MutableStateFlow(listOf<MainState>())
    //val tasks_ = mutableTasks_.asStateFlow()

    init {
        Log.e("!", "VM created")
/*        mutableTasks_.tryEmit(listOf(
            MainState(
                title = "Test",
                color = 0xFFD0BCFF)
        )
        )*/
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }

    fun reduce(event: MainEvent){
        when(event){
/*            is Save -> {
                save(text = event.text)
            }*/
/*            is MainEvent.GetTasksEvent ->{
                getTasks()
            }*/

            MainEvent.ShowEmptyEvent -> {
                _state.tryEmit(MainUIState.Empty)

            }
            MainEvent.ShowAllTasksEvent -> {
                getTasks()

            }

            is MainEvent.DeleteTaskEvent -> TODO()
            MainEvent.HideDialog -> TODO()
            is MainEvent.SetDateOfChangeEvent -> TODO()
            is MainEvent.SetTitleEvent -> TODO()
            MainEvent.ShowDialog -> TODO()
            is MainEvent.SortTask -> TODO()
            MainEvent.UpsertTaskEvent -> TODO()
        }
    }
/*   fun getAllTasks(): List<MainState> =
       mutableTasks_.tryEmit(getTasksUseCase().map { taskModel -> taskModel })*/
    private fun getTasks(){
        _state.tryEmit(MainUIState.Tasks(getTasksUseCase()))
/*        val test = getTasksUseCase()
        mutableTasks_.tryEmit(getTasksUseCase())
        mutableTasks_.tryEmit(listOf(
            MainState(
                title = "Test",
                color = 0xFFD0BCFF)))
        mutableTasks.tryEmit(getTasksUseCase())*/


        //mutableTasks.tryEmit(getTasksUseCase())
        //taskStorage.getAllTasks().map { taskEntity -> taskEntity.toModel()}
    }
}
