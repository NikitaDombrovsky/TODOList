package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.data.Final.storage.TaskDatabase

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: TaskDatabase) = db.dao()