package dev.alimansour.to_docompose.ui.screen.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import dev.alimansour.to_docompose.data.model.ToDoTask
import dev.alimansour.to_docompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }) {

    }
}