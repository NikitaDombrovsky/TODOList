//package com.example.todolist.data.storage.Test.ui
//
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import com.example.roomkt.ContactEvent
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddContactDialog(
//    state: ContactState,
//    onEvent: (ContactEvent) -> Unit,
//    modifier: Modifier = Modifier
//) {
///*    AlertDialog(
//        onDismissRequest = { *//*TODO*//* },
//        title = {
//            Text(text = stringResource(id = R.string.add_contact))
//        },
//    ) {
//
//    }*/
//    AlertDialog(
//        modifier = modifier,
//        icon = {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = stringResource(id = R.string.add_contact)
//            )
//        },
//        title = {
//            Text(text = stringResource(id = R.string.add_contact))
//        },
//        text = {
//            Column(
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                TextField(
//                    value = state.firstName,
//                    onValueChange = {
//                        onEvent(ContactEvent.SetFirstName(it))
//                    },
//                    placeholder = {
//                        Text(text = "First name") //https://youtu.be/bOd3wO0uFr8?si=194YdYzilymFYuGS&t=2321
//
//                    }
//                )
//                TextField(
//                    value = state.lastName,
//                    onValueChange = {
//                        onEvent(ContactEvent.SetLastName(it))
//                    },
//                    placeholder = {
//                        Text(text = "Last name")
//
//                    }
//                )
//                TextField(
//                    value = state.phoneNumber,
//                    onValueChange = {
//                        onEvent(ContactEvent.SetPhoneNumber(it))
//                    },
//                    placeholder = {
//                        Text(text = "Phone number")
//
//                    }
//                )
//            }
//        },
//        onDismissRequest = {
//            onEvent(ContactEvent.HideDialog)
//        },
//        confirmButton = {
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.CenterEnd
//            ){
//                Button(
//                    onClick = {
//                        onEvent(ContactEvent.SaveContact)
//                    }
//                ) {
//                    Text("Save")
//                }
//            }
///*            TextButton(
//                onClick = {
//                    onEvent(ContactEvent.SaveContact)
//                    //onConfirmation()
//                }
//            ) {
//                Text("Save")
//            }*/
//        },
//        dismissButton = {
//            TextButton(
//                onClick = {
//                    //onDismissRequest()
//                }
//            ) {
//                Text("Dismiss")
//            }
//        }
//    )
//
//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun AlertDialogExample(
//        onDismissRequest: () -> Unit,
//        onConfirmation: () -> Unit,
//        dialogTitle: String,
//        dialogText: String,
//        icon: ImageVector,
//    ) {
//        AlertDialog(
//            icon = {
//                Icon(icon, contentDescription = "Example Icon")
//            },
//            title = {
//                Text(text = dialogTitle)
//            },
//            text = {
//                Text(text = dialogText)
//            },
//            onDismissRequest = {
//                onDismissRequest()
//            },
//            confirmButton = {
//                TextButton(
//                    onClick = {
//                        onConfirmation()
//                    }
//                ) {
//                    Text("Confirm")
//                }
//            },
//            dismissButton = {
//                TextButton(
//                    onClick = {
//                        onDismissRequest()
//                    }
//                ) {
//                    Text("Dismiss")
//                }
//            }
//        )
//    }
//}