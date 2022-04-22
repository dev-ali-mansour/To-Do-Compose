package dev.alimansour.to_docompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.alimansour.to_docompose.data.dao.ToDoDao
import dev.alimansour.to_docompose.data.model.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun todoDao(): ToDoDao
}