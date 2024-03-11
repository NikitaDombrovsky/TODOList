package com.example.todolist.presentation.Main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.data.storage.TaskStorageImpl
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {
    private val taskStorage by lazy { TaskStorageImpl(context) }
    private val taskRepositoryImpl by lazy { TaskRepositoryImpl(taskStorage) }
    private val getTasksUseCase by lazy { GetTasksUseCase(taskRepositoryImpl) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getTasksUseCase = getTasksUseCase,
            taskStorage = taskStorage,
            taskRepositoryImpl = taskRepositoryImpl
        ) as T
    }
}