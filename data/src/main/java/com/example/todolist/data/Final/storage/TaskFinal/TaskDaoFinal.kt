package com.example.todolist.data.Final.storage.TaskFinal

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.data.Final.storage.TaskDetailsDTO
import kotlinx.coroutines.flow.Flow

interface TaskDaoFinal {


    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id ORDER BY id DESC")
    suspend fun getAllTasks() : List<TaskDetailsDTO> //TODO LiveData вместо Flow
/*    @Query("SELECT * FROM Tasks JOIN Category ORDER BY id DESC")
    fun getAllTaskFinal() : LiveData<List<TaskEntityFinal>>*/
    @Insert
    suspend fun addTask(task : TaskDetailsDTO)
    @Delete
    suspend fun deleteTask(id: Int)
    @Update
    suspend fun updateTask(id: Int)
    @Query("SELECT Tasks.*,Category.* FROM Tasks INNER JOIN Category ON Tasks.categoryId = Category.id WHERE Tasks.id = :id")
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
    suspend fun getTasksOrderedByCategoryName() : Flow<List<TaskDetailsDTO>>
}