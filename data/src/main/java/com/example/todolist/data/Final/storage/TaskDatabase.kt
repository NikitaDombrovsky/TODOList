package com.example.todolist.data.Final.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.Final.storage.Categoty.CategoryEntity
import com.example.todolist.data.Final.storage.TaskFinal.TaskDao
import com.example.todolist.data.Final.storage.TaskFinal.TaskEntity
import java.util.Locale.Category

@Database(
    entities = [TaskEntity::class, CategoryEntity::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    //abstract val dao: TaskDao
    abstract fun dao(): TaskDao
}

