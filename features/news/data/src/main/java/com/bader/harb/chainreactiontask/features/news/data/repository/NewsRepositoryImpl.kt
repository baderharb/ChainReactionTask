package com.bader.harb.chainreactiontask.features.news.data.repository

import com.bader.harb.chainreactiontask.core.network.entity.RequestState
import com.bader.harb.chainreactiontask.core.storage.room.repository.NewsLocalRepository
import com.bader.harb.chainreactiontask.features.news.data.mapper.NewsMapper
import com.bader.harb.chainreactiontask.features.news.data.remote.RemoteNewsDataSource
import com.bader.harb.chainreactiontask.features.news.domain.models.NewsListModel
import com.bader.harb.chainreactiontask.features.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import result
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val remoteNewsDataSource: RemoteNewsDataSource,
    private val newsLocalRepository: NewsLocalRepository,
    private val newsMapper: NewsMapper,
) : NewsRepository {
    override suspend fun getPopularNews(period: Int): Flow<RequestState<List<NewsListModel>>> =
        result(
            query = {
                newsLocalRepository.getAllNews().map { it.map { newsMapper.map(it) } }
            },
            fetch = {
                remoteNewsDataSource.getPopularNews(period).results?.map { item ->
                    newsMapper.map(item)
                }
            },
            saveFetchResult = { items ->
                newsLocalRepository.clearAll()
                newsLocalRepository.insertAllNews(items?.map { newsListModel ->
                    newsMapper.map(
                        newsListModel
                    )
                })
            },
            isFetch = { items ->
                true
            }
        )
}