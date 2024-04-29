package com.example.todolist.presentation.Main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.Search
import com.example.todolist.presentation.Task
import com.example.todolist.presentation.TaskDetail.TaskDetail


@Composable
fun TasksScreen(
    state: MainUIState,
    //onEvent: (TaskEvent) -> Unit
) {
    when(state) {
        MainUIState.Empty -> {
            Loading()
        }
        MainUIState.Loading -> {
            Loading()
        }
        is MainUIState.Tasks -> {
            Main(tasks = state.tasksList)
        }
    }
}
@Composable
fun Loading(){

}
/*fun onQueryChange(test: String) : (String) -> Unit {
    return
}*/
fun showString(x: String): Unit { Log.e("!x", x) } //TODO Как с этим работать я не до конца понимаю
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    tasks: List<TaskModel_>,
    modifier: Modifier = Modifier
) {
    var presses by remember { mutableIntStateOf(0) }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val onQueryChange_ : String = ""

    Scaffold(
        topBar = {
            Column {

                var showStringFunction1: (String) -> Unit = ::showString
                showStringFunction1("")
                //TopBar(onQueryChange = showStringFunction1, modifier = modifier)
                Row {
                    Search(onQueryChange = showStringFunction1, modifier = modifier)
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                }

            }

        },
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                presses++
              //  TaskDetail(task = tasks)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Body( tasks,innerPadding = innerPadding)
    }
}
@Composable
fun Body(
    tasks: List<TaskModel_>,
    innerPadding: PaddingValues
){
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            items(tasks) { task ->
                Task(task = task, Modifier.fillParentMaxWidth())
            }
        }
    }
}