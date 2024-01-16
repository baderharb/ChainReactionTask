package com.bader.harb.chainreactiontask.features.news.domain.usecase

import com.bader.harb.chainreactiontask.features.news.domain.repository.NewsRepository
import javax.inject.Inject

class PopularNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke(period: Int) = repository.getPopularNews(period)
}
