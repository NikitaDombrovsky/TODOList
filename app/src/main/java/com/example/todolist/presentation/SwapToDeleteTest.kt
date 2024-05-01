package com.example.todolist.presentation
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.Main.Category
import com.example.todolist.presentation.Main.Main
import com.example.todolist.presentation.ui.theme.DimenTaskClip
import kotlin.math.roundToInt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestView(
    tasks: List<TaskModel_>,
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
    task: TaskModel_,
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
    TestView(tasks = testList, onTestClick = {

    })

}
/*@Composable
fun ItemUI(
    modifier: Modifier = Modifier,
    list: List<String>,
    itemIndex: Int) {
    Card(
        modifier.padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
        Box(
            modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(text = list[itemIndex], fontSize = 32.sp, fontWeight = FontWeight.Bold)

        }
    }
}*/
/*@Composable
fun ItemUI_(
    modifier: Modifier = Modifier,
    list: List<String>,
    itemIndex: Int) {
    Card(
        modifier.padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
        Box(
            modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(text = list[itemIndex], fontSize = 32.sp, fontWeight = FontWeight.Bold)

        }
    }
}*/
/*
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalDraggableSample2(
    modifier: Modifier = Modifier,
    task: TaskModel_,
    onTestClick: () -> Unit
) {
    var selectedIndex by remember{mutableStateOf(-1)}
    val density = LocalDensity.current
    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors_.Half,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            //animationSpec = tween(),
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow,
            ),
        )
    }
    val contentSize = 80.dp
    val contentSizePx = with(density) { contentSize.toPx() }
    Card (
        modifier = modifier
            .pointerInput(Unit) {
                // TODO Favorits
                */
/*                detectTapGestures(
                                    onDoubleTap = { todoListViewModel.toggleStarred(item) }
                                )*//*

            }
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
            .selectable(
                selected = task.id == selectedIndex,
                onClick = onTestClick

                */
/*                        onClick = {if (selectedIndex != task.id)
                                        selectedIndex = task.id else selectedIndex = -1}*//*

            )
            .onSizeChanged { layoutSize ->
                val dragEndPoint = layoutSize.width - contentSizePx
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors_
                            .values()
                            .forEach { anchor ->
                                anchor at dragEndPoint * anchor.fraction
                            }
                    }
                )
            },
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(DimenTaskClip))
                .background(color = Color(task.color))
        ){
            Text(
                text = task.title,
                modifier = Modifier
                    .padding(all = 7.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}*/

/*enum class DragAnchors_(val fraction: Float) {
    Start(0f),
    Half(.5f),
    End(1f),
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalDraggableSample(
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors_.Half,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            //animationSpec = tween(),
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow,
            ),
        )
    }
    val contentSize = 80.dp
    val contentSizePx = with(density) { contentSize.toPx() }
    Box(
        modifier
            .onSizeChanged { layoutSize ->
                val dragEndPoint = layoutSize.width - contentSizePx
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors_
                            .values()
                            .forEach { anchor ->
                                anchor at dragEndPoint * anchor.fraction
                            }
                    }
                )
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_icon),
            modifier = Modifier
                .size(contentSize)
                .offset {
                    IntOffset(
                        x = state
                            .requireOffset()
                            .roundToInt(),
                        y = 0,
                    )
                }
                .anchoredDraggable(state, Orientation.Horizontal),
            contentDescription = null,
        )
    }
}*/

