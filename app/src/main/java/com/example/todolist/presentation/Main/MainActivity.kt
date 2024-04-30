package com.example.todolist.presentation.Main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.room.Room

import com.example.todolist.R
import com.example.todolist.data.storage.TaskDatabase
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.Search
import com.example.todolist.presentation.TaskDetail.TaskDetail
import com.example.todolist.presentation.ui.theme.TODOListTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "tasks.db"
        ).build()
    }
   // private lateinit var vm: MainViewModel //by ViewModel
    //viewModel ищет правила для создания viewModel
    private val vm: MainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Room DI(Koin) ViewModel Ковер Поиск Категории Уведомления ВыборФона
        // https://youtu.be/Mn8WwqbndGg?si=azj9dpvh04RgZzHw
        // https://insert-koin.io/docs/setup/why
        setContent {
            TODOListTheme {
                Log.e("!", "Activity created")
                val navController = rememberNavController()
                //https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state#4
/*                vm = ViewModelProvider(this,
                    MainViewModelFactory(this)
                )
                    .get(MainViewModel::class.java)*/
                vm.reduce(MainEvent.ShowAllTasksEvent)
               // vm.send(MainEvent.GetTasksEvent())
                //vm.getTasks_()
                val state by vm.state.collectAsState()
                NavHost(navController = navController, startDestination = "mainActivity"){
                    composable(route = "mainActivity"){
                        TasksScreen(state = state, onTestClick = {
                            navController.navigate("taskDetails")

                        })
                       // Main(tasks = state.tasksList)
                    }
                    composable(route = "taskDetails"){
                        TaskDetail(task = TaskModel_(0,stringResource(id = R.string.sample_text), "",0)) //TODO Убрать
                    }
                }

                //TasksScreen(state = state)
               // val tasks by vm.tasks_.collectAsState()
                //Main(tasks = tasks)
                // getTasks(tasks = getTasksUseCase())
                /*                val tasks = getTasksUseCase()
                                Main(tasks = tasks);*/
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onQueryChange: (String) -> Unit,
    //isSearchActive: Boolean,
    //onActiveChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
           // Text("Top app bar")
            Row {
                Search(onQueryChange = onQueryChange, modifier = modifier)
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                //Text("Top app bar")
            }

        }
    )
}

@Composable
fun BottomBar(){
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Bottom app bar",
        )
    }
}




@Preview(showBackground = true)
@Composable
fun TODOPreview() {
    val testList: List<TaskModel_> = listOf(
        TaskModel_(2, "0", "0", 0xFFD0BCFF),
        TaskModel_(0, "0", "2", 0x1),
        TaskModel_(1, "0", "1", 0xFFD0BCFF),
        TaskModel_(3, "0", "3", 0x1),
        TaskModel_(4, "0", "4", 0x1)
    ).sortedBy {
        // TODO Для разных режимов сортировки
        it.title
    }/*.groupBy {
        it.title.first()
    }.toSortedMap()*/
    Main(tasks = testList, onTestClick = {

    })

}

