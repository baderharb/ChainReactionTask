package com.bader.harb.chainreactiontask.core.storage.di

import android.content.Context
import androidx.room.Room
import com.bader.harb.chainreactiontask.core.storage.room.ChainReactionTaskDatabase
import com.bader.harb.chainreactiontask.core.storage.room.dao.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomLocalDataModule {

    @Provides
    @Singleton
    fun provideChainReactionTaskDatabase(@ApplicationContext appContext: Context): ChainReactionTaskDatabase {
        return Room.databaseBuilder(
            appContext,
            ChainReactionTaskDatabase::class.java,
            "ChainReactionTaskDatabase"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(chainReactionTaskDatabase: ChainReactionTaskDatabase): NewsDao {
        return chainReactionTaskDatabase.newsDao()
    }
}