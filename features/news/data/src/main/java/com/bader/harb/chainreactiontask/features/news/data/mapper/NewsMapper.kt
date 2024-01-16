package com.bader.harb.chainreactiontask.features.news.data.mapper

import com.bader.harb.chainreactiontask.core.storage.room.model.NewsLocalModel
import com.bader.harb.chainreactiontask.features.news.data.remote.response.RemoteNewsListModel
import com.bader.harb.chainreactiontask.features.news.domain.models.NewsListModel

import javax.inject.Inject

class NewsMapper @Inject constructor() {

    fun map(source: RemoteNewsListModel?): NewsListModel {
        return NewsListModel(
            id = source?.id,
            assetId = source?.assetId,
            source = source?.source,
            abstract = source?.abstract,
            publishedDate = source?.publishedDate,
            section = source?.section,
            title = source?.title,
            updatedDate = source?.updatedDate,
            url = source?.url
        )
    }

    fun map(source: NewsLocalModel?): NewsListModel {
        return NewsListModel(
            id = source?.id,
            assetId = source?.assetId,
            source = source?.source,
            abstract = source?.abstract,
            publishedDate = source?.publishedDate,
            section = source?.section,
            title = source?.title,
            updatedDate = source?.updatedDate,
            url = source?.url,
        )
    }

    fun map(source: NewsListModel?): NewsLocalModel {
        return NewsLocalModel(
            id = source?.id,
            assetId = source?.assetId,
            source = source?.source,
            abstract = source?.abstract,
            publishedDate = source?.publishedDate,
            section = source?.section,
            title = source?.title,
            updatedDate = source?.updatedDate,
            url = source?.url,
        )
    }
}
