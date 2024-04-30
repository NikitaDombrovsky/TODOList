package com.example.todolist.data.storage.Category

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="nameOfCategory")
    val name: String,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="colorOfCategory")
    val color: Long,
    @ColumnInfo(name="textColorOfCategory")
    val textColor: Long,
    @ColumnInfo(name="secondColorOfCategory")
    val secondColor: Long,
    @ColumnInfo(name="thirdColorOfCategory")
    val thirdColor: Long,
    @ColumnInfo(name="imageOfCategory")
    val image: ByteArray? = null
) {

}