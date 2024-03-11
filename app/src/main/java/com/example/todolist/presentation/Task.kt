package com.example.todolist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel


@Composable
fun Task(task: TaskModel, modifier: Modifier = Modifier){
    Row (
        modifier = Modifier.fillMaxWidth().background(color = Color(task.color))
    ){
        Text(text = task.title)
        Text(text = task.text) //TODO

    }

}
@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    Task(task = TaskModel(id = 0, text = "0", title = "0", color = 0xFFD0BCFF))
}