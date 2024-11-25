package com.example.todolist.presentation.Main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.todolist.presentation.ErrorDialog.ErrorDialog
import com.example.todolist.presentation.ErrorDialog.ErrorDialogState

@Composable
fun MainRoute(
    mainViewModel: MainViewModel,
    navController: NavController,
    isExpanded: Boolean
) {
    val uiState by mainViewModel.state.collectAsState()

    val dialogState by mainViewModel.dialogState.collectAsState()
    MainRoute(
        uiState = uiState,
        onCreateTask = { navController.navigate("taskDetails") },
        onOpenTaskDetails = { navController.navigate("taskDetails") },
        onSearch = {},
        onTaskItemDissmiss = {},
        onTaskItemClick = {},
        onErrorDismiss = {}
    )

}

@Composable
private fun MainRoute(
    // TODO
    //isExpanded: Boolean,
    dialogState: ErrorDialogState,
    uiState: MainUIState,
    onCreateTask: () -> Unit,
    onOpenTaskDetails: (Int) -> Unit,
    onSearch: (String) -> Unit,
    onTaskItemDissmiss: (Int) -> Unit,
    onTaskItemClick: (Int) -> Unit,
    onErrorDismiss: () -> Unit,
){
    var taskListState = rememberLazyListState()
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            MainRoute(
                tasksListState = taskListState,
                uiState = uiState,
                onCreateTask = onCreateTask,
                onOpenTaskDetails = onOpenTaskDetails,
                onSearch = onSearch,
                onTaskItemDissmiss = onTaskItemDissmiss,
                onTaskItemClick = onTaskItemClick,
                onErrorDismiss = onErrorDismiss
            )
/*            MainRoute(
                taskListState = taskListState,
                uiState = uiState,
                onCreateTask = onCreateTask,
                onOpenTaskDetails = onOpenTaskDetails,
                onSearch = onSearch,
                onTaskItemDissmiss = onTaskItemDissmiss,
                onTaskItemClick = onTaskItemClick,
                onErrorDismiss = onErrorDismiss
            ) */

        }
    }

}

@Composable
private fun MainRoute(
    tasksListState: LazyListState,
    uiState: MainUIState,
    onCreateTask: () -> Unit,
    onOpenTaskDetails: (Int) -> Unit,
    onSearch: (String) -> Unit,
    onTaskItemDissmiss: (Int) -> Unit,
    onTaskItemClick: (Int) -> Unit,
    onErrorDismiss: () -> Unit
) {
    ErrorDialog(state = , onOkClick = { /*TODO*/ }, onDismiss = { /*TODO*/ })
/*    when (uiState) {
        is GeneralUiState.HasCharacters -> {
            GeneralScreenWithCharacters(
                isExpanded = isExpanded,
                characters = uiState.characters,
                charactersLazyListState = charactersLazyListState,
                onChangeVisibleCharacter = onChangeVisibleHero,
                onCharacterClick = onHeroClick,
                onMoreLoad = onMoreLoad
            )
        }
        GeneralUiState.Loading -> GeneralLoadingScreen(isExpanded)
        GeneralUiState.NoCharacters -> GeneralScreenWithoutCharacters(isExpanded)
    }
    ErrorDialog(state = dialogState, onOkClick = onErrorDismiss, onDismiss = onErrorDismiss)*/
}
/*
* @Composable
fun GeneralRoute(
    generalViewModel: GeneralViewModel,
    navController: NavController,
    isExpanded: Boolean
) {
    val uiState by generalViewModel.state.collectAsState()
    val dialogState by generalViewModel.dialogState.collectAsState()
    GeneralRoute(
        isExpanded = isExpanded,
        uiState = uiState,
        dialogState = dialogState,
        onChangeVisibleHero = { generalViewModel.changeVisibleHero(it) },
        onHeroClick = { navController.navigate("${MarvelDestinations.CHARACTER_DETAILS_ROUTE}/${it}") },
        onMoreLoad = { generalViewModel.load(it) },
        onErrorDismiss = { generalViewModel.closeDialog() }
    )

}

@Composable
private fun GeneralRoute(
    isExpanded: Boolean,
    uiState: GeneralUiState,
    dialogState: ErrorDialogState,
    onChangeVisibleHero: (Int) -> Unit,
    onHeroClick: (Int) -> Unit,
    onMoreLoad: (Int) -> Unit,
    onErrorDismiss: () -> Unit,
) {
    val generalListLazyListState = rememberLazyListState()

    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            GeneralRoute(
                isExpanded = isExpanded,
                uiState = uiState,
                dialogState = dialogState,
                charactersLazyListState = generalListLazyListState,
                onChangeVisibleHero = onChangeVisibleHero,
                onHeroClick = onHeroClick,
                onMoreLoad = onMoreLoad,
                onErrorDismiss = onErrorDismiss,
            )
        }
    }
}

@Composable
private fun GeneralRoute(
    isExpanded: Boolean,
    uiState: GeneralUiState,
    dialogState: ErrorDialogState,
    charactersLazyListState: LazyListState,
    onChangeVisibleHero: (Int) -> Unit,
    onHeroClick: (Int) -> Unit,
    onMoreLoad: (Int) -> Unit,
    onErrorDismiss: () -> Unit,
) {
    when (uiState) {
        is GeneralUiState.HasCharacters -> {
            GeneralScreenWithCharacters(
                isExpanded = isExpanded,
                characters = uiState.characters,
                charactersLazyListState = charactersLazyListState,
                onChangeVisibleCharacter = onChangeVisibleHero,
                onCharacterClick = onHeroClick,
                onMoreLoad = onMoreLoad
            )
        }
        GeneralUiState.Loading -> GeneralLoadingScreen(isExpanded)
        GeneralUiState.NoCharacters -> GeneralScreenWithoutCharacters(isExpanded)
    }
    ErrorDialog(state = dialogState, onOkClick = onErrorDismiss, onDismiss = onErrorDismiss)
}*/