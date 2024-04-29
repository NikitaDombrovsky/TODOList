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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
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
                .padding(all = 15.dp)
                .align(Alignment.CenterVertically)
                .background(color = Color(task.color)),
                text = task.title,
                style = TextStyle(color = Color.Black,
                    fontSize = TextUnit.Unspecified,
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
    // we are creating a variable for
    // getting a value of our text field.
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = task.text,
       // onValueChange = { inputvalue.value = it },
        onValueChange = { },
        placeholder = { Text(text = "Text") },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(task.color)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorScheme.primary,
            unfocusedContainerColor = Color(task.color),

        ),
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
            fontFamily = FontFamily.SansSerif
        ),
       // maxLines = 2,
/*        leadingIcon = {
            // In this method we are specifying
            // our leading icon and its color.
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "", tint = colorResource(id = R.color.purple_200))
        },*/
        // trailing icons is use to add
        // icon to the end of text field.
/*        trailingIcon = {
            //Icon(Icons.Filled.Info, tint = colorResource(id = R.color.purple_200))
            Icon(imageVector = Icons.Filled.Info, contentDescription = "", tint = colorResource(id = R.color.purple_200))
        }*/

    )


}


@Preview(showBackground = true)
@Composable
fun TaskPreview1() {
    TaskDetail(task = TaskModel_(id = 0,
        text = stringResource(id = R.string.sample_text),
        title = "Тестовый тайтл",
        color = 0xFFD0BCFF))
}

