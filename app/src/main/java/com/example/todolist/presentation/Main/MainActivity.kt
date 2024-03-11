package com.example.todolist.presentation.Main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R
import com.example.todolist.data.repository.TaskRepositoryImpl
import com.example.todolist.data.storage.TaskStorageImpl
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.usecase.TaskUseCase.DetailsTaskUseCase
import com.example.todolist.domain.usecase.TasksUseCase.CreateTaskUseCase
import com.example.todolist.domain.usecase.TasksUseCase.GetTasksUseCase
import com.example.todolist.presentation.Task
import com.example.todolist.presentation.ui.theme.TODOListTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
/*    private val taskStorage by lazy {
        TaskStorageImpl(
            applicationContext
        )
    }
    private val taskRepositoryImpl by lazy {
        TaskRepositoryImpl(
            taskStorage
        )
    }
    private val getTasksUseCase by lazy {
        GetTasksUseCase(
            taskRepositoryImpl
        )
    }
    private val createTaskUseCase by lazy {
        CreateTaskUseCase(
            taskRepositoryImpl
        )
    }
    private val detailsTaskUseCase by lazy {
        DetailsTaskUseCase(
            taskRepositoryImpl
        )
    }*/
    private lateinit var vm: MainViewModel //by ViewModel TODO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Room DI ViewModel Ковер Поиск Категории Уведомления
        // https://youtu.be/Mn8WwqbndGg?si=azj9dpvh04RgZzHw
        setContent {
            TODOListTheme {
                Log.e("!", "Activity created")
                //https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state#4
                vm = ViewModelProvider(this,
                    MainViewModelFactory(this)
                )
                    .get(MainViewModel::class.java)
                vm.getTasks_()

                val tasks by vm.tasks.collectAsState()
                Main(tasks = tasks)
                // getTasks(tasks = getTasksUseCase())
                /*                val tasks = getTasksUseCase()
                                Main(tasks = tasks);*/
            }
        }
    }
}


@Composable
fun Main(tasks: List<TaskModel>, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.met_silk_kashan_carpet),
                contentScale = ContentScale.FillWidth
            ),

        //color = MaterialTheme.colorScheme.background
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
    val testList: List<TaskModel> = listOf(TaskModel(0, "0", "0", 0x1))
    Main(tasks = testList)
/*    val taskRepositoryImpl = TaskRepositoryImpl(context = c)
   val getTasksUseCase = GetTasksUseCase(taskRepositoryImpl)*/

}

