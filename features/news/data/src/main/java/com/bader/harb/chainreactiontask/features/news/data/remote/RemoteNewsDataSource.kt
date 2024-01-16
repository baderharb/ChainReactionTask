package com.bader.harb.chainreactiontask.features.news.data.remote

import com.bader.harb.chainreactiontask.features.news.data.remote.response.RemoteNewsListWrapper
import retrofit2.http.*

interface RemoteNewsDataSource {

    @GET("mostpopular/v2/viewed/{period}.json")
    suspend fun getPopularNews(
        @Path("period") period: Int?,
        @Query("api-key") apiKey: String = "kGmooOoRC6vlN2TSGMlthmKXgqZ3Sgwj",
    ): RemoteNewsListWrapper
}