package com.example.todolist.presentation.Main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.core.Reducer
import com.example.todolist.domain.Final.usecase.TasksUseCase.GetTasksUseCase
import com.example.todolist.presentation.TaskPreview.TaskPreviewView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class _MainViewModel (
    private val getTasksUseCase: GetTasksUseCase
): ViewModel() {
    private val _state : MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Loading)
    val state = _state.asStateFlow()
    private val reducer = MainReducer(MainUIState.Loading)
    private fun sendEvent(event: MainEvent) = reducer.sendEvent(event)
    init {

        Log.e("!", "VM created")
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }
    private fun showAllTasks() {
        viewModelScope.launch {
            //_state.tryEmit(MainUIState.Tasks(getTasks()))
            sendEvent(MainEvent.ShowAllTasks(getTasks()))
  /*          when (val result = charactersRepository.getCharacters(offset)) {
                is Either.Right -> sendEvent(GeneralScreenUiEvent.AddCharacters(result.b.map { it.toCharacterView() }))
                is Either.Left -> {
                    sendEvent(GeneralScreenUiEvent.HideCharactersList)
                    sendEvent(ErrorDialogEvent.Open(result.a))
                }
            }*/
        }
    }
    suspend private fun getTasks() =
        getTasksUseCase().map {tasks -> TaskPreviewView(
            id = tasks.id,
            title = tasks.title,
            deadline = tasks.deadline,
            changedAt = tasks.changedAt,
            checkedStatus = tasks.checkedStatus,
            colorOfCategory = tasks.colorOfCategory)
        }

/*    fun reduce(event: MainEvent){
        when(event){
            MainEvent.ShowEmpty -> {
                _state.tryEmit(MainUIState.Empty)

            }
            MainEvent.ShowAllTasks -> {
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
    }*/
    /*   fun getAllTasks(): List<MainState> =
           mutableTasks_.tryEmit(getTasksUseCase().map { taskModel -> taskModel })*/


    //val tasks = getTasksUseCase()


    //_state.tryEmit(MainUIState.Tasks(tasksView))

}

private class MainReducer(initial: MainUIState):
    Reducer<MainUIState, MainEvent>(initial){
    override fun reduce(oldState: MainUIState, event: MainEvent) {
        when (event) {
            MainEvent.Loading -> setState(MainUIState.Loading)
            MainEvent.ShowEmpty -> setState(
                MainUIState.Empty
            )

            is MainEvent.ShowAllTasks -> setState(
                MainUIState.Tasks(event.tasks)
            )
/*            MainEvent.ShowAllTasks -> {
                viewModelScope.launch {
                    _state.tryEmit(MainUIState.Tasks(getTasks()))
                    //getTasks()
                }
            }*/
/*            GeneralScreenUiEvent.LoadCharacters -> setState(GeneralUiState.Loading)
            is GeneralScreenUiEvent.ChangeCentralVisibleCharacter -> setState(
                (oldState as GeneralUiState.HasCharacters).copy(
                    visibleCharacter = oldState.characters.find { it.id == event.characterId }
                        ?: oldState.characters.first())
            )
            is GeneralScreenUiEvent.AddCharacters -> {
                val characters: MutableList<CharacterView> = mutableListOf()
                if (oldState is GeneralUiState.HasCharacters) characters.addAll(oldState.characters)
                if (!characters.containsAll(event.characters)) characters.addAll(event.characters)

                setState(
                    GeneralUiState.HasCharacters(
                        characters = characters,
                        visibleCharacter = characters.first()
                    )
                )
            }
            GeneralScreenUiEvent.HideCharactersList -> setState(GeneralUiState.NoCharacters)*/
            MainEvent.HideDialog -> TODO()
            is MainEvent.SetDateOfChange -> TODO()
            is MainEvent.SetTitle -> TODO()
            //MainEvent.ShowAllTasksEvent -> TODO()
            MainEvent.ShowDialog -> TODO()
            //MainEvent.ShowEmptyEvent -> TODO()
            is MainEvent.SortTask -> TODO()
            MainEvent.UpsertTask -> TODO()
        }
    }


}