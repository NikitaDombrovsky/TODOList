package com.example.todolist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.Main.Category
import com.example.todolist.presentation.ui.theme.DimenTaskClip


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task(
    task: TaskModel_,
    modifier: Modifier = Modifier,
    onTestClick: () -> Unit
){
    var selectedIndex by remember{mutableStateOf(-1)}
/*    val dismissState = rememberDismissState(confirmStateChange = {
        if (it == DismissValue.DismissedToEnd) {

        }
        true
    })*/
    Card (
        modifier = modifier
            .pointerInput(Unit) {
                // TODO Favorits
/*                detectTapGestures(
                    onDoubleTap = { todoListViewModel.toggleStarred(item) }
                )*/
            }
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
            .selectable(
                selected = task.id == selectedIndex,
                onClick = onTestClick

                /*                        onClick = {if (selectedIndex != task.id)
                                        selectedIndex = task.id else selectedIndex = -1}*/
            ),
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
                modifier = Modifier.padding(all = 7.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }

}
@Composable
fun Divider(
    //task: TaskModel_
    task: String,
    //task: Category,
    modifier: Modifier = Modifier,
){

    Card (
        modifier = modifier
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier
                .height(60.dp)
                .clip(RoundedCornerShape(DimenTaskClip))
                .background(color = Color.Green)
                //.background(color = Color(task.color))
        ){
            Text(
                text = task,
                modifier = Modifier.padding(all = 7.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    Task(task = TaskModel_(id = 0,
        text = "0",
        title = "Тестовый тайтл",
        color = 0xFFD0BCFF),
        onTestClick = {

        })
}
@Preview(showBackground = true)
@Composable
fun DividerPreview() {
    Divider(task = "25.04")

}
/*@Preview(showBackground = true)
@Composable
fun DividerPreview() {
    Divider(task = TaskModel_(id = 0,
        text = "0",
        title = "Тестовый тайтл",
        color = 0xFFD0BCFF)
    )
}*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState: DismissState) {
    val color = when (dismissState.dismissDirection) {
        DismissDirection.StartToEnd -> Color(0xFFFF1744)
        DismissDirection.EndToStart -> Color(0xFF1DE9B6)
        null -> Color.Transparent
    }
    val direction = dismissState.dismissDirection

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (direction == DismissDirection.StartToEnd) Icon(
            Icons.Default.Delete,
            contentDescription = "delete"
        )
        Spacer(modifier = Modifier)
        if (direction == DismissDirection.EndToStart) Icon(
            // make sure add baseline_archive_24 resource to drawable folder
            painter = painterResource(R.drawable.test_icon),
            contentDescription = "Archive"
        )
    }
}
//TODO Дизайн получше
/*@Composable
fun GameLayout(modifier: Modifier = Modifier) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(mediumPadding)
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(R.string.word_count, 0),
                style = typography.titleMedium,
                color = colorScheme.onPrimary
            )
            Text(
                text = "scrambleun",
                style = typography.displayMedium
            )
            Text(
                text = stringResource(R.string.instructions),
                textAlign = TextAlign.Center,
                style = typography.titleMedium
            )
            OutlinedTextField(
                value = "",
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(containerColor = colorScheme.surface),
                onValueChange = { },
                label = { Text(stringResource(R.string.enter_your_word)) },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
        }
    }
}*/