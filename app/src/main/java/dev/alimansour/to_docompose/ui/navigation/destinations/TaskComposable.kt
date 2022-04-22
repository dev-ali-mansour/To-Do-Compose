package dev.alimansour.to_docompose.ui.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.alimansour.to_docompose.util.Action
import dev.alimansour.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import dev.alimansour.to_docompose.util.Constants.LIST_SCREEN
import dev.alimansour.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import dev.alimansour.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen: (Action) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {

    }
}