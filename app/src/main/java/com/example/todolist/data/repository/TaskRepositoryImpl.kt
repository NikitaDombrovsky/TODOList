package com.example.todolist.data.repository

import android.content.Context
import android.util.Log
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.repository.TaskRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_TITLE = "first_title"
private const val KEY_TEXT = "first_text"
private const val KEY_COLOR = "0xFFD0BCFF"
class TaskRepositoryImpl(private val context: Context) : TaskRepository {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    override fun getAllTasks(): List<TaskModel> {
        return  listOf(
            TaskModel(id = 0, text = "0", title = "0", color =  0xFFD0BCFF),
            TaskModel(id = 1, text = "1", title = "0", color =  0xFFD0BCFF),
            TaskModel(id = 2, text = "2", title = "0", color =  0xFFD0BCFF)
        )
    }

    override fun getTaskDetails(): TaskModel{
        val title = sharedPreferences.getString(KEY_TITLE, "") ?: ""
        val text = sharedPreferences.getString(KEY_TEXT, "") ?: ""
        val color = sharedPreferences.getString(KEY_COLOR, "")

        return TaskModel(0,text, title, 0x1)
    }
    override fun saveTask(taskModel: TaskModel): Boolean{
        val newtask: TaskModel = taskModel //TODO
        sharedPreferences.edit().putString(KEY_TITLE, taskModel.title) //TODO А Как
        Log.e("!Task", "Task Saved!")
        return true
    }
}