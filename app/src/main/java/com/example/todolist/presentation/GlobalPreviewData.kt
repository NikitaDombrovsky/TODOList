package com.example.todolist.presentation

import com.example.todolist.presentation.Main.TaskViewFinal

fun getPreviewDatas(): List<TaskViewFinal> {
    val testList: List<TaskViewFinal> = listOf(
        TaskViewFinal(2, "дабуди", 0,0, false, 0xFFD0BCFF),
        TaskViewFinal(0, "дабудай", 2,1, false, 0x1),
        TaskViewFinal(1, "вантудай", 1,0, true, 0xFFD0BCFF),
        TaskViewFinal(3, "пита", 2,0, true, 0),

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
fun getPreviewData(): TaskViewFinal{
    return TaskViewFinal(0, "папам", 2,1, false, 0xFFD0BCFF)
    //TaskModelFinal(0,)
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


