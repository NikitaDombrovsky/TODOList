package com.example.todolist.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.todolist.R
import com.example.todolist.presentation.TaskDetail.TaskDetailsView
import com.example.todolist.presentation.TaskPreview.TaskPreviewView

fun getPreviewDatas(): List<TaskPreviewView> {
    val testList: List<TaskPreviewView> = listOf(
        TaskPreviewView(2, "дабуди", 0,0, false, 0xFFD0BCFF),
        TaskPreviewView(0, "дабудай", 2,1, false, 0x1),
        TaskPreviewView(1, "вантудай", 1,0, true, 0xFFD0BCFF),
        TaskPreviewView(3, "пита", 2,0, true, 0),

/*        TaskView_(2, "0", 0xFFD0BCFF),
        TaskView_(0, "0", 0x1),
        TaskView_(1, "0", 0xFFD0BCFF),
        TaskView_(3, "0", 0x1),
        TaskView_(4, "0", 0x1)*/
    )/*.sortedBy {
        // TODO Для разных режимов сортировки
        it.title
    }*/
    return testList
}
fun getPreviewData(): TaskPreviewView {
    return TaskPreviewView(0, "папам", 2,1, false, 0xFFD0BCFF)
    //TaskModelFinal(0,)
}
fun getDetailsData(): TaskDetailsView {
    return TaskDetailsView(0, "папам", "парапум",2,1,
        false, 1,"черная как черный",
        0xFFD0BCFF, 0xFF000000, 0xFFD0BCFF, 0x1)
}
@Composable
fun getDetailsData2(): TaskDetailsView {
   val text : String=  stringResource(id = R.string.sample_text)
    return TaskDetailsView(0,  text, "парапум",2,1,
        false, 1,"черная как черный",
        0xFFD0BCFF, 0xFF000000, 0xFFD0BCFF, 0x1)
}
/*fun getPreviewDatas(): List<TaskView_> {
    val testList: List<TaskView_> = listOf(
        TaskView_(2, "0", 0xFFD0BCFF),
        TaskView_(0, "0", 0x1),
        TaskView_(1, "0", 0xFFD0BCFF),
        TaskView_(3, "0", 0x1),
        TaskView_(4, "0", 0x1)
    ).sortedBy {
        // TODO Для разных режимов сортировки
        it.title
    }
    return testList
}
fun getPreviewData(): TaskViewFinal{
    //TaskModelFinal(0,)
}*/


