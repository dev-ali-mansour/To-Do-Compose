package dev.alimansour.to_docompose.ui.navigation

import androidx.navigation.NavHostController
import dev.alimansour.to_docompose.util.Action
import dev.alimansour.to_docompose.util.Constants.LIST_SCREEN

class Screens(val navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}