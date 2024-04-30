package com.example.todolist.presentation.Main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController

@Composable
fun MainRoute(
    mainViewModel: MainViewModel,
    navController: NavController,
    isExpanded: Boolean
) {
    val uiState by mainViewModel.state.collectAsState()
   // val dialogState by mainViewModel.dialogState.collectAsState()

}
@Composable
private fun MainRoute(
    isExpanded: Boolean,
    uiState: MainUIState,
    //dialogState: ErrorDialogState,
    onChangeVisibleHero: (Int) -> Unit,
    onHeroClick: (Int) -> Unit,
    onMoreLoad: (Int) -> Unit,
    onErrorDismiss: () -> Unit,
){

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