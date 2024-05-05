package com.example.todolist.di

import com.example.todolist.domain.Final.usecase.TasksUseCase.GetTasksUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetTasksUseCase> {
        GetTasksUseCase(taskRepository = get())
    }
}
