package com.example.todolist.di
import com.example.todolist.data.Final.repositoty.DatabaseRepositoryFinal
import com.example.todolist.data.Final.repositoty.TaskRepositoryImplFinal

import com.example.todolist.domain.Final.repository.TaskRepositoryFinal
import org.koin.android.ext.koin.androidContext

import org.koin.dsl.module

val dataModule = module {

    single { provideDatabase(androidContext()) }
    single{ provideDao(get())}
    factory { DatabaseRepositoryFinal(get()) }


    /*    single<TaskDatabase> { TaskDatabase_Impl()}

      single<TaskDao> { TaskDao_Impl(get()) }*/
       single<TaskRepositoryFinal> { TaskRepositoryImplFinal(taskStorage = get()) }


    //single<TaskStorage> { TaskStorageImpl (context = get()) }


}

