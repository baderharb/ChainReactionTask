package com.bader.harb.chainreactiontask.features.news.data.di

import com.bader.harb.chainreactiontask.features.news.data.repository.NewsRepositoryImpl
import com.bader.harb.chainreactiontask.features.news.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NewsRepositoryModule {

    @Binds
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository
}
