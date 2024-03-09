package com.example.todolist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.usecase.TaskUseCase.DetailsTaskUseCase
import com.example.todolist.domain.usecase.TasksUseCase.CreateTaskUseCase
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase
import com.example.todolist.presentation.ui.theme.TODOListTheme


class MainActivity : ComponentActivity() {
    private val taskRepositoryImpl by lazy { TaskRepositoryImpl(applicationContext) }
    private val getTasksUseCase by lazy { GetTasksUseCase(taskRepositoryImpl) }
    private val createTaskUseCase by lazy { CreateTaskUseCase(taskRepositoryImpl) }
    private val detailsTaskUseCase by lazy { DetailsTaskUseCase(taskRepositoryImpl)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MapKit Room DI ViewModel Retrofit Supabase Ковер
        //
        setContent {
            TODOListTheme {
                val tasks = getTasksUseCase()
                Main(tasks = tasks);
            }
        }
    }
}


@Composable
fun Main(tasks: List<TaskModel>, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            ){
            items(tasks) { task ->
                Task(task = task)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun TODOPreview() {
/*    val taskRepositoryImpl = TaskRepositoryImpl(context = c)
   val getTasksUseCase = GetTasksUseCase(taskRepositoryImpl)
    Main(tasks = getTasksUseCase())*/
}

