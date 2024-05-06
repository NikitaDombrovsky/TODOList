package com.example.todolist.presentation.Main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.room.Room

import com.example.todolist.data.Final.storage.TaskDatabase
import com.example.todolist.presentation.TaskDetail.TaskDetail
import com.example.todolist.presentation.TestView
import com.example.todolist.presentation.getDetailsData
import com.example.todolist.presentation.getPreviewDatas
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

                vm.reduce(MainEvent.ShowAllTasksEvent)

                val state by vm.state.collectAsState()
                NavHost(navController = navController, startDestination = "mainActivity"){
                    composable(route = "mainActivity"){
                        TasksScreen(state = state, onTestClick = {
                            navController.navigate("taskDetails")

                        })
                    }
                    composable(route = "taskDetails"){
                        TaskDetail(task = getDetailsData(),
                            onMoreVertClick = {
                                navController.navigate("testView")
                            }
                        ) //TODO Убрать
                    }
                    composable(route = "testView"){
                        TestView(tasks = getPreviewDatas(),
                            onTestClick = {
                                navController.navigate("taskDetails")
                            })
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


/*@OptIn(ExperimentalMaterial3Api::class)
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
}*/

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
    Main(tasks = getPreviewDatas(), onTestClick = {

    })

}

