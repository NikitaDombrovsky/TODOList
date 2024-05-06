package com.example.todolist.data.Final.storage.TaskFinal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.data.Final.storage.TaskDetailsDTO
import com.example.todolist.data.Final.storage.TaskPreviewDTO
import kotlinx.coroutines.flow.Flow
@Dao
interface TaskDao {


    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY id DESC")
    suspend fun getAllTasks() : List<TaskPreviewDTO> //TODO LiveData вместо Flow
/*    @Query("SELECT * FROM Tasks INNER JOIN Category ORDER BY id DESC")
    suspend fun getAllTasks() : List<TaskPreviewDTO> //TODO LiveData вместо Flow*/
/*    @Query("SELECT * FROM Tasks JOIN Category ORDER BY id DESC")
    fun getAllTaskFinal() : LiveData<List<TaskEntityFinal>>*/
    @Insert
    suspend fun addTask(task : TaskEntity)
    @Delete
    suspend fun deleteTask(task : TaskEntity)
    @Update
    suspend fun updateTask(task : TaskEntity)
/*    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id WHERE Tasks.id = :id")
    suspend fun getTaskDetailsFinal(id:Int): Flow<TaskDetailsDTO>
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY title DESC")
    suspend fun getTasksOrderedByTitle() : Flow<List<TaskDetailsDTO>>
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY deadline DESC")
    suspend fun getTasksOrderedByDeadline() : Flow<List<TaskDetailsDTO>>
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY changedAt DESC")
    suspend fun getTasksOrderedByChangeAt() : Flow<List<TaskDetailsDTO>>
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY checkedStatus DESC")
    suspend fun getTasksOrderedByCheckedStatus() : Flow<List<TaskDetailsDTO>>
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY nameOfCategory DESC")
    suspend fun getTasksOrderedByCategoryName() : Flow<List<TaskDetailsDTO>>*/
}