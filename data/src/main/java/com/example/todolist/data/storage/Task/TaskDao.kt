package com.example.todolist.data.storage.Task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
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
