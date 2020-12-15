package com.example.randstadsearchanimapplication.service

import com.example.randstadsearchanimapplication.model.AnimeResponse
import com.example.randstadsearchanimapplication.utils.API_QUERY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimSearchService {

    @GET("v3/search/anime") ///anime?q=naruto
    suspend fun getSearchByAnime(@Query(API_QUERY) anime: String): Response<AnimeResponse>
}