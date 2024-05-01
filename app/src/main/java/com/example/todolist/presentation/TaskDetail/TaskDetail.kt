package com.example.todolist.presentation.TaskDetail


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.ui.theme.DimenTaskClip


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetail(
    task: TaskModel_,
    modifier: Modifier = Modifier,
    onMoreVertClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopBar(task = task, onMoreVertClick = onMoreVertClick)
        },
    ) { innerPadding ->
        BodyDetails(task = task, Modifier.padding(innerPadding)
            //TODO Color3
            .background(color =  Color(task.color))
        )
    }


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    task: TaskModel_,
    modifier: Modifier = Modifier,
    onMoreVertClick: () -> Unit
)
{
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            //TODO Color3
            containerColor = Color(task.color)
        ),
        title = {
            Card (
                modifier = modifier.padding(start = 0.dp, top = 20.dp,
                    end = 16.dp, bottom = 12.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ){

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(DimenTaskClip))
                        .background(color = Color(task.color)),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(modifier = Modifier
                        .padding(all = 15.dp)
                        .align(Alignment.CenterVertically)
                        .background(color = Color(task.color)),
                        text = if (task.title != "")
                        {
                            task.title
                        } else {
                            "Text"
                        },
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontFamily = FontFamily.SansSerif
                        )

                    )
                    IconButton(onClick = onMoreVertClick,
                        modifier = Modifier.align(Alignment.CenterVertically)) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
        )
}
@Composable
fun BodyDetails(
    task: TaskModel_,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier.padding(start = 16.dp, top = 2.dp, end = 16.dp, bottom = 12.dp)
            //.verticalScroll(rememberScrollState())
        ,
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        TxtField(task = task)
    }
}
@Composable
fun BodyDetailsOld(
    task: TaskModel_,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier.padding(start = 16.dp, top = 2.dp, end = 16.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){

        Row (
            modifier = Modifier
                .fillMaxWidth()
                //.padding(innerPadding)
                .height(60.dp)
                .clip(RoundedCornerShape(DimenTaskClip))
                .background(color = Color(task.color))
        ){
            Text(modifier = Modifier
                .padding(all = 15.dp)
                .align(Alignment.CenterVertically)
                .background(color = Color(task.color)),
                text = if (task.title != "")
                {
                    task.title
                } else {
                    "Text"
                },
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif
                )

            )
        }
        TxtField(task = task)
    }
}

@Composable
fun TxtField(
    task: TaskModel_,
    modifier: Modifier = Modifier) {
    // TODO ДЕЛАЙ
    val message = remember{mutableStateOf(task.text)}
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        //value = task.text,
        value = message.value,
       // onValueChange = { inputvalue.value = it },
        onValueChange = {  newText -> message.value = newText },
        placeholder = { Text(text = "Text") },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(task.color))
            .verticalScroll(rememberScrollState()),
        colors = TextFieldDefaults.colors(
            // TODO если цвета поедут
            //focusedContainerColor = colorScheme.primary,
            unfocusedContainerColor = Color(task.color),

        ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
        ),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            //fontSize = TextUnit.Companion.Unspecified,
            fontFamily = FontFamily.SansSerif
        ),


    )


}


@Preview(showBackground = true)
@Composable
fun TaskPreview1() {
    TaskDetail(task = TaskModel_(id = 0,
        text = stringResource(id = R.string.sample_text),
        title = "Тестовый тайтл",
        color = 0xFFD0BCFF),
        onMoreVertClick = {})
}
@Preview(showBackground = true)
@Composable
fun TaskPreviewEmpty() {
    TaskDetail(task = TaskModel_(id = 0,
        text = "",
        title = "",
        color = 0), onMoreVertClick = {})
}

