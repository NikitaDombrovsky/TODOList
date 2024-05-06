package com.example.todolist.presentation.Main

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.presentation.Search
import com.example.todolist.presentation.SwipeTask
import com.example.todolist.presentation.TaskPreview.TaskPreviewView


@Composable
fun TasksScreen(
    state: MainUIState,
    onTestClick: () -> Unit //= {}
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
            Main(tasks = state.tasksList,
                onTestClick = onTestClick
            )
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
    //tasks: List<TaskModel_>,
    tasks: List<TaskPreviewView>,
    modifier: Modifier = Modifier,
    onTestClick: () -> Unit// = {}
) {
/*    var presses by remember { mutableIntStateOf(0) }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val onQueryChange_ : String = ""*/
   // val  onTestClick: () -> Unit

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
            FloatingActionButton(onClick = onTestClick
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
/*        floatingActionButton = {
            FloatingActionButton(onClick = {
                presses++
              //  TaskDetail(task = tasks)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }*/
    ) { innerPadding ->
        Body_Switch( tasks,innerPadding = innerPadding, onTestClick = onTestClick)
        val namesList = tasks.map {
            Category(
                name = it.title,
                items = tasks
            )
        }
       // Body( namesList,innerPadding = innerPadding, onTestClick = onTestClick)

    }
}
data class Category(
    val name: String,
   // val items: List<TaskModel_>
    val items: List<TaskPreviewView>
)

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Body_Switch(
    //tasks: List<TaskModel_>,
    tasks: List<TaskPreviewView>,
    innerPadding: PaddingValues,
    onTestClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.met_silk_kashan_carpet),
                contentScale = ContentScale.FillWidth
            ),
    ) {

        LazyColumn(
            //TODO Какой state?
            state= rememberLazyListState(),
            contentPadding = PaddingValues(10.dp),
            //
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            // TODO Настрал
            items(tasks) { task ->
                val state = rememberDismissState(
                    confirmValueChange = {
/*                        if (it == DismissValue.DismissedToStart){
                            list.remove(item)
                        }*/
                        true
                    }
                )
                SwipeTask(state, task = task, onTestClick = onTestClick)
            }
        }
    }
}
