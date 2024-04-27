package com.example.todolist.di

import com.example.todolist.presentation.Main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>(){
        MainViewModel(
            getTasksUseCase = get()

        )
    }
}