package com.bader.harb.chainreactiontask.core.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bader.harb.chainreactiontask.core.storage.room.dao.NewsDao
import com.bader.harb.chainreactiontask.core.storage.room.model.NewsLocalModel

@Database(entities = [NewsLocalModel::class], version = 1)
abstract class ChainReactionTaskDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}