package com.example.todolist.di

import com.example.todolist.domain.usecase.GetTasksUseCase_
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetTasksUseCase_> {
        GetTasksUseCase_(taskRepository = get())
    }
}
