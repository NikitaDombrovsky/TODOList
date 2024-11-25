package com.example.todolist.presentation.Main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.domain.Final.usecase.TasksUseCase.GetTasksUseCase
import com.example.todolist.presentation.TaskPreview.TaskPreviewView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel(
    private val getTasksUseCase: GetTasksUseCase
): ViewModel() {
    private val _state : MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Loading)
    val state = _state.asStateFlow()

    init {
        Log.e("!", "VM created")
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }

    fun reduce(event: MainEvent){
        when(event){
            MainEvent.ShowEmpty -> {
                _state.tryEmit(MainUIState.Empty)

            }
/*            MainEvent.ShowAllTasks -> {
                viewModelScope.launch {
                    _state.tryEmit(MainUIState.Tasks(getTasks()))
                    //getTasks()
                }
            }*/
            is MainEvent.ShowAllTasks -> {
                viewModelScope.launch {
                    _state.tryEmit(MainUIState.Tasks(getTasks()))
                    //getTasks()
                }

            }
            //is MainEvent.DeleteTaskEvent -> TODO()
            MainEvent.HideDialog -> TODO()
            is MainEvent.SetDateOfChange -> TODO()
            is MainEvent.SetTitle -> TODO()
            MainEvent.ShowDialog -> TODO()
            is MainEvent.SortTask -> TODO()
            MainEvent.UpsertTask -> TODO()
            MainEvent.Loading -> TODO()

        }
    }
/*   fun getAllTasks(): List<MainState> =
       mutableTasks_.tryEmit(getTasksUseCase().map { taskModel -> taskModel })*/
    suspend private fun getTasks() =
        getTasksUseCase().map {tasks -> TaskPreviewView(
            id = tasks.id,
            title = tasks.title,
            deadline = tasks.deadline,
            changedAt = tasks.changedAt,
            checkedStatus = tasks.checkedStatus,
            colorOfCategory = tasks.colorOfCategory)
        }

        //val tasks = getTasksUseCase()


        //_state.tryEmit(MainUIState.Tasks(tasksView))

    }



