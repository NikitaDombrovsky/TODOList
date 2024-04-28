package com.example.todolist.presentation.TaskDetail


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.models.TaskModel_
import com.example.todolist.presentation.ui.theme.DimenTaskClip
import java.lang.Exception


@Composable
fun TaskDetail(
    task: TaskModel_,
    modifier: Modifier = Modifier){
    Card (
        modifier = modifier.padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(DimenTaskClip))
                .background(color = Color(task.color))
        ){
            Text(modifier = Modifier
                .padding(all = 7.dp)
                .align(Alignment.CenterVertically)
                .background(color = Color(task.color)),
                text = task.title)

        }
        //Detail(task = task)
        TxtField(task = task)
    }

}

@Composable
fun TxtField(
    task: TaskModel_,
    modifier: Modifier = Modifier) {
    // we are creating a variable for
    // getting a value of our text field.
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = task.text,
        onValueChange = {},
        // placeholder = { Text(text = "Enter user name") }
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(task.color)),
        colors = TextFieldDefaults.colors(
            // TODO Рофла ради
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = Color(task.color),
        ),

        )
       /* TextField(
            // below line is used to get
            // value of text field,
            value = inputvalue.value,

            // below line is used to get value in text field
            // on value change in text field.
            onValueChange = { inputvalue.value = it },

            // below line is used to add placeholder
            // for our text field.
            placeholder = { Text(text = "Enter user name") },

            // modifier is use to add padding
            // to our text field.
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),

            // keyboard options is used to modify
            // the keyboard for text field.
            keyboardOptions = KeyboardOptions(
                // below line is use for capitalization
                // inside our text field.
                capitalization = KeyboardCapitalization.None,

                // below line is to enable auto
                // correct in our keyboard.
                autoCorrect = true,

                // below line is used to specify our
                // type of keyboard such as text, number, phone.
                keyboardType = KeyboardType.Text,
            ),

            // below line is use to specify
            // styling for our text field value.
            textStyle = TextStyle(color = Color.Black,
                // below line is used to add font
                // size for our text field
                //fontSize = TextUnit.Companion.Sp(value = 15),
                fontSize = TextUnit.Companion.Unspecified,

                // below line is use to change font family.
                fontFamily = FontFamily.SansSerif),

            // below line is use to give
            // max lines for our text field.
            maxLines = 2,

            // active color is use to change
            // color when text field is focused.
            activeColor = colorResource(id = R.color.purple_200),

            // single line boolean is use to avoid
            // textfield entering in multiple lines.
            singleLine = true,

            // inactive color is use to change
            // color when text field is not focused.
            inactiveColor = Color.Gray,

            // below line is use to specify background
            // color for our text field.
            backgroundColor = Color.LightGray,

            // leading icon is use to add icon
            // at the start of text field.
            leadingIcon = {
                // In this method we are specifying
                // our leading icon and its color.
                Icon(Icons.Filled.AccountCircle, tint = colorResource(id = R.color.purple_200))
            },
            // trailing icons is use to add
            // icon to the end of text field.
            trailingIcon = {
                Icon(Icons.Filled.Info, tint = colorResource(id = R.color.purple_200))
            },
        )*/

}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    TaskDetail(task = TaskModel_(id = 0,
        text = stringResource(id = R.string.sample_text),
        title = "Тестовый тайтл",
        color = 0xFFD0BCFF))
}
@Composable
fun Detail(
    task: TaskModel_,
    modifier: Modifier = Modifier){
    Card (
        modifier = modifier.padding(start = 0.dp, top = 2.dp, end = 0.dp, bottom = 0.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .height(60.dp)
                .clip(RoundedCornerShape(DimenTaskClip))
                .background(color = Color(task.color))
        ){

            Text(modifier = Modifier
                .padding(all = 7.dp)
                .align(Alignment.Top)
                .background(color = Color(task.color)),
                text = task.text)
        }
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