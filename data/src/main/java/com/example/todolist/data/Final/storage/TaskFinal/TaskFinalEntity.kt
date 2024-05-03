package com.example.todolist.data.Final.storage.TaskFinal
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.todolist.data.Final.storage.Categoty.CategoryEntity
import com.example.todolist.domain.Final.models.TaskFinalModel

@Entity(tableName = "Tasks",
    foreignKeys = [
        ForeignKey(
            CategoryEntity::class,
            parentColumns = ["Id"],
            childColumns =["categoryId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ])
data class TaskFinalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="text")
    val text: String,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="deathLine")
    val deadline: Int,
    @ColumnInfo(name="changeAt")
    val changeAt: Int,
    @ColumnInfo(name="checkedStatus")
    val checkedStatus: Boolean,
    @ColumnInfo(name="categoryId")
    val categoryId: Int,
){
    companion object {
        /* TODO Сделать

                val empty = MovieDetailsEntity(
            0, String.empty(), String.empty(), String.empty(),
            String.empty(), String.empty(), 0, String.empty()
        )
        * */
    }
}
fun TaskFinalEntity.toModel(): TaskFinalModel {
    return TaskFinalModel(id, text, title, deadline, changeAt,checkedStatus, categoryId)
}
fun TaskFinalEntity.Companion.fromModel(taskModel: TaskFinalModel): TaskFinalEntity {
    return TaskFinalEntity(taskModel.id, taskModel.text, taskModel.title,
        taskModel.deadline, taskModel.changeAt, taskModel.checkedStatus,
        taskModel.categoryId)
}

