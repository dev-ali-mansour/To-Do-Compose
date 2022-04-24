package dev.alimansour.to_docompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.alimansour.to_docompose.data.model.ToDoTask
import dev.alimansour.to_docompose.data.repositories.ToDoRepository
import dev.alimansour.to_docompose.util.RequestState
import dev.alimansour.to_docompose.util.SearchAppBarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: ToDoRepository) :
    ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    private val _selectedTask = MutableStateFlow<ToDoTask?>(null)

    val allTasks: StateFlow<RequestState<List<ToDoTask>>>
        get() = _allTasks
    val selectedTask: StateFlow<ToDoTask?>
        get() = _selectedTask

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        runCatching {
            viewModelScope.launch {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        }.onFailure { t ->
            _allTasks.value = RequestState.Error(t)
        }
    }

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            repository.getSelectedTask(taskId = taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }
}