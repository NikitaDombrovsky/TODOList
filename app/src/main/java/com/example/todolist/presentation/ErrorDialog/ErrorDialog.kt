package com.example.todolist.presentation.ErrorDialog

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.R
import com.example.todolist.core.Failure
import com.example.todolist.core.UiEvent
import com.example.todolist.core.UiState


@Composable
fun ErrorDialog(
    state: ErrorDialogState,
    onOkClick: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (state is ErrorDialogState.Visible) {
        AlertDialog(
            icon = {
                Icon(Icons.Rounded.Warning,
                    contentDescription = "Warning Icon")
            },
            title = {
                Text(
                    modifier = modifier.padding(16.dp),
                    text = when (state.messageId == null)
                    {
                        true -> state.message ?: stringResource(id = R.string.unexpected_error)
                        false -> stringResource(id = state.messageId)
                    },
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp
                )
            },
            onDismissRequest = onDismiss,
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                Button(onClick = onOkClick) {
                    Text(stringResource(id = R.string.ok))
                }
            }}
        )
    }
}

sealed interface ErrorDialogState : UiState {
    data class Visible(@StringRes val messageId: Int? = null, val message: String? = null) : ErrorDialogState
    object Invisible : ErrorDialogState
}

sealed class ErrorDialogEvent : UiEvent {
    data class Open(val failure: Failure) : ErrorDialogEvent()
    object Close : ErrorDialogEvent()
}