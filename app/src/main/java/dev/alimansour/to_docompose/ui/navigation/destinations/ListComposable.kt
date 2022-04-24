package dev.alimansour.to_docompose.ui.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.alimansour.to_docompose.ui.screen.list.ListScreen
import dev.alimansour.to_docompose.ui.viewmodels.SharedViewModel
import dev.alimansour.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import dev.alimansour.to_docompose.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}