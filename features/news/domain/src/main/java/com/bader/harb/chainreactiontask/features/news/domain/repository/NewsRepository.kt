package com.bader.harb.chainreactiontask.features.news.domain.repository

import com.bader.harb.chainreactiontask.core.network.entity.RequestState
import com.bader.harb.chainreactiontask.features.news.domain.models.NewsListModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getPopularNews(period: Int = 1): Flow<RequestState<List<NewsListModel>>>
}