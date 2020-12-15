package com.example.randstadsearchanimapplication.repository

import com.example.randstadsearchanimapplication.model.AnimeObject
import com.example.randstadsearchanimapplication.model.AnimeResponse
import com.example.randstadsearchanimapplication.service.AnimSearchService
import com.example.randstadsearchanimapplication.service.RetrofitCallHandler
import com.example.randstadsearchanimapplication.service.RetrofitService
import com.example.randstadsearchanimapplication.service.ServiceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeSearchRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val animeService: AnimSearchService = RetrofitService.createService(
        AnimSearchService::class.java
    )
) : AnimeSearchRepository {

    override suspend fun fetchSearchData(anime: String): ServiceResult<AnimeObject> {
        val result = withContext(ioDispatcher) {
            RetrofitCallHandler.processCall {
                animeService.getSearchByAnime(anime)
            }
        }

        return when(result) {
            is ServiceResult.Success -> transformResponseToAnimeObject(result.data)
            is ServiceResult.Error -> result
        }
    }

    private fun transformResponseToAnimeObject(response: AnimeResponse) : ServiceResult<AnimeObject> {
        response.apply {

            response.let {
                return ServiceResult.Success(it)
            }

            return ServiceResult.Error(Exception())
        }
    }
}