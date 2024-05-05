package com.example.todolist.data.Final.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.Final.storage.TaskFinal.TaskDaoFinal
import com.example.todolist.data.Final.storage.TaskFinal.TaskEntityFinal

@Database(
    entities = [TaskEntityFinal::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    //abstract val dao: TaskDao
    abstract fun dao(): TaskDaoFinal
}

