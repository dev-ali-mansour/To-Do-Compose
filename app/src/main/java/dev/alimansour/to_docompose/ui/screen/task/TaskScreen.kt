package dev.alimansour.to_docompose.ui.screen.task

import android.content.Context
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import dev.alimansour.to_docompose.data.model.Priority
import dev.alimansour.to_docompose.data.model.ToDoTask
import dev.alimansour.to_docompose.ui.viewmodels.SharedViewModel
import dev.alimansour.to_docompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

    BackHandler(onBackPressed = { navigateToListScreen(Action.NO_ACTION) })

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                }
            )
        }) { paddingValues ->
        TaskContent(
            paddingValues = paddingValues,
            title = title,
            onTitleChange = {
                sharedViewModel.updateTitle(it)
            },
            description = description,
            onDescriptionChange = {
                sharedViewModel.description.value = it
            },
            priority = priority,
            onPrioritySelected = {
                sharedViewModel.priority.value = it
            }
        )
    }
}

fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty", Toast.LENGTH_SHORT).show()
}

@Composable
fun BackHandler(
    backDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backDispatcher) {
        backDispatcher?.addCallback(backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}
