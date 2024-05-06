package com.example.todolist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.presentation.TaskPreview.TaskPreviewView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestView(
    tasks: List<TaskPreviewView>,
    onTestClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column {
            Box {
                LazyColumn(
                    state= rememberLazyListState(),
                    contentPadding = PaddingValues(10.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(tasks) { task ->
                        val state = rememberDismissState(
                            confirmValueChange = {
                                if (it == DismissValue.DismissedToStart){
                                    onTestClick()
                                }
                                else if (it == DismissValue.DismissedToEnd){
                                    onTestClick
                                }
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
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeTask(
    state: DismissState,
    //task: TaskModel_,
    task: TaskPreviewView,
    modifier: Modifier = Modifier,
    onTestClick: () -> Unit
){
    SwipeToDismiss(

        //TODO А какой state?
        state = state,
        background = {
            SwipeItemBackground(state)
        },
        dismissContent = {
            Task(task = task, onTestClick = onTestClick);
        }
    )
}
/*enum class DragAnchors_(val fraction: Float) {
    Start(0f),
    Half(.5f),
    End(1f),
}*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeItemBackground(
    state: DismissState
){
    val color = when(state.dismissDirection){
        DismissDirection.EndToStart-> Color.Transparent
        DismissDirection.StartToEnd-> Color.Red
        null-> Color.Black
    }
    Card (
        modifier = Modifier
            .fillMaxWidth()
            //.fillMaxHeight()
            .pointerInput(Unit) {
            }
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(color),
        //elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color)
                //.clip(RoundedCornerShape(DimenTaskClip))
        ){
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",
                modifier = Modifier.padding(all = 7.dp)
                    .align(Alignment.CenterVertically)
                //modifier = Modifier.align(Alignment.CenterStart)
            )
/*            Text(
                text = task.title,
                modifier = Modifier.padding(all = 7.dp)
                    .align(Alignment.CenterVertically)
            )*/
        }

    }
/*    // TODO Задний фон изменения
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color)
        .padding(horizontal = 20.dp, vertical = 6.dp),


    ){
        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",
            modifier = Modifier.align(Alignment.CenterStart))
        *//*Icon(imageVector = Icons.Default.Edit, contentDescription = "edit",
            modifier = Modifier.align(Alignment.CenterStart))*//*
    }*/
}
@Preview(showBackground = true)
@Composable
fun SwapToDeleteTestPreview() {
    TestView(tasks = getPreviewDatas(), onTestClick = {

    })

/*    val testList: List<TaskView_> = listOf(
        TaskView_(2, "0", 0xFFD0BCFF),
        TaskView_(0, "0",  0x1),
        TaskView_(1, "0",  0xFFD0BCFF),
        TaskView_(3, "0",  0x1),
        TaskView_(4, "0",  0x1)
    ).sortedBy {
        // TODO Для разных режимов сортировки
        it.title
    }*//*.groupBy {
        it.title.first()
    }.toSortedMap()*//*
    TestView(tasks = testList, onTestClick = {

    })*/

}