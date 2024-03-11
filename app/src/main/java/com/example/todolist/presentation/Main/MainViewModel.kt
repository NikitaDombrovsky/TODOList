package com.example.todolist.presentation.Main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.data.storage.TaskStorageImpl
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel(
    private val taskStorage: TaskStorageImpl,
    private val taskRepositoryImpl: TaskRepositoryImpl,
    private val getTasksUseCase: GetTasksUseCase
): ViewModel() {
    private val mutableTasks = MutableStateFlow(listOf<TaskModel>())
    val tasks = mutableTasks.asStateFlow()

    init {
        Log.e("!", "VM created")
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }

    fun getTasks_(){
        mutableTasks.tryEmit(getTasksUseCase())

    }
}