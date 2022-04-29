package dev.alimansour.to_docompose.ui.navigation

import androidx.navigation.NavHostController
import dev.alimansour.to_docompose.util.Action
import dev.alimansour.to_docompose.util.Constants.LIST_SCREEN
import dev.alimansour.to_docompose.util.Constants.SPLASH_SCREEN

class Screens(val navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}