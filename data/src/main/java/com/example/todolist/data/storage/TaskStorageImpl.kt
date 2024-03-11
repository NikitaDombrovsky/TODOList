package com.example.todolist.data.storage

import android.content.Context
import android.util.Log

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_TITLE = "first_title"
private const val KEY_TEXT = "first_text"
private const val KEY_COLOR = "0xFFD0BCFF"
class TaskStorageImpl(private val context: Context) : TaskStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    override fun getAllTasks(): List<TaskEntity> {
        return  listOf(
            TaskEntity(id = 0, text = "0", title = "0", color =  0xFFD0BCFF),
            TaskEntity(id = 1, text = "1", title = "0", color =  0xFFD0BCFF),
            TaskEntity(id = 2, text = "2", title = "0", color =  0xFFD0BCFF)
        )
    }

    override fun getTaskDetails(): TaskEntity {
        val title = sharedPreferences.getString(KEY_TITLE, "") ?: ""
        val text = sharedPreferences.getString(KEY_TEXT, "") ?: ""
        val color = sharedPreferences.getString(KEY_COLOR, "")

        return TaskEntity(0,text, title, 0x1)
    }

    override fun save(taskEntity: TaskEntity): Boolean {
        val newtask: TaskEntity = taskEntity //TODO
        sharedPreferences.edit().putString(KEY_TITLE, taskEntity.title) //TODO А Как
        Log.e("!Task", "Task Saved!")
        return true
    }

}