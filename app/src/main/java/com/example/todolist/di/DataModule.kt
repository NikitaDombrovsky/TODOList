package com.example.todolist.di
//import com.example.todolist.data.repository.TaskRepositoryImpl
import androidx.room.RoomDatabase
import com.example.todolist.data.repository.DatabaseRepository
import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.data.storage.Task.TaskDao
import com.example.todolist.data.storage.Task.TaskDao_Impl
import com.example.todolist.data.storage.TaskDatabase
import com.example.todolist.data.storage.TaskDatabase_Impl
/*import com.example.todolist.data.storage.TaskStorage
import com.example.todolist.data.storage.TaskStorageImpl*/
import com.example.todolist.domain.repository.TaskRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val dataModule = module {

    single { provideDatabase(androidContext()) }
    single{ provideDao(get())}
    factory { DatabaseRepository(get()) }


    /*    single<TaskDatabase> { TaskDatabase_Impl()}

      single<TaskDao> { TaskDao_Impl(get()) }*/
       single<TaskRepository> { TaskRepositoryImpl(taskStorage = get()) }


    //single<TaskStorage> { TaskStorageImpl (context = get()) }


}

