package com.example.todolist.data.storage.TaskFinal

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.todolist.data.storage.Task.TaskEntity_

interface TaskFinalDao {

    @Query("SELECT * FROM taskfinalentity ORDER BY id DESC")
    fun getAllTaskFinal() : LiveData<List<TaskFinalEntity>>
    @Insert
    suspend fun addTodo(todo : TaskFinalEntity)

    @Query("Delete FROM Todo where id = :id")
    fun deleteTodo(id : Int)
    @Upsert
    fun upsertTask(task: TaskEntity_) // TODO Suspend
    @Delete
    fun deleteTask(task: TaskEntity_)
    @Query("SELECT * FROM taskentity_ task_table ORDER BY id DESC")
    fun getAllTasks(): List<TaskEntity_>
    /*    @Query("SELECT * FROM taskentity_")
        fun getAllTasks(): List<TaskEntity_>*/

    @Query("SELECT * FROM taskentity_ WHERE id = :id")
    fun getTaskDetails(id : Int): TaskEntity_ // TODO FLow<> не работает с toModel
    @Query("SELECT * FROM taskentity_ ORDER BY title ASC")
    fun getTaskOrderedByTitle(): List<TaskEntity_>
    /*    @Query("SELECT * FROM taskentity_ ORDER BY dateOfChange ASC")
        fun getTaskOrderedByDateOfChange(): Flow<List<TaskEntity_>>*/
}