package com.example.todolist.data.Final.storage.Categoty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Category"
)
class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val Id: Int = 0,
    @ColumnInfo(name="nameOfCategory")
    val nameOfCategory: String,
    @ColumnInfo(name="colorOfCategory")
    val colorOfCategory: Long,
    @ColumnInfo(name="textColorOfCategory")
    val textColor: Long,
    @ColumnInfo(name="secondColorOfCategory")
    val secondColor: Long,
    @ColumnInfo(name="thirdColorOfCategory")
    val thirdColor: Long,
/*    @ColumnInfo(name="imageOfCategory")
    val image: ByteArray? = null*/
) {

}