package dev.alimansour.to_docompose.data.repositories

import dagger.hilt.android.scopes.ViewModelScoped
import dev.alimansour.to_docompose.data.ToDoDatabase
import dev.alimansour.to_docompose.data.dao.ToDoDao
import dev.alimansour.to_docompose.data.model.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowQuality()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHigQuality()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> = toDoDao.getSelectedTask(taskId = taskId)

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(todoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(todoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(todoTask = toDoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> =
        toDoDao.searchDatabase(searchQuery = searchQuery)


}