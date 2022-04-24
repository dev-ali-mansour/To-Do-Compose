package dev.alimansour.to_docompose.ui.navigation.destinations

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.alimansour.to_docompose.ui.screen.task.TaskScreen
import dev.alimansour.to_docompose.ui.viewmodels.SharedViewModel
import dev.alimansour.to_docompose.util.Action
import dev.alimansour.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import dev.alimansour.to_docompose.util.Constants.LIST_SCREEN
import dev.alimansour.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import dev.alimansour.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId = taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()
        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}