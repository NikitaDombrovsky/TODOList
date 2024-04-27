package com.example.todolist.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.storage.Task.TaskDao
import com.example.todolist.data.storage.Task.TaskEntity_

@Database(
    entities = [TaskEntity_::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    //abstract val dao: TaskDao
    abstract fun dao(): TaskDao
}

