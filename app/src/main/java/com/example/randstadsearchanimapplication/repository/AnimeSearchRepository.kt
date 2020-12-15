package com.example.randstadsearchanimapplication.repository

import com.example.randstadsearchanimapplication.model.AnimeObject
import com.example.randstadsearchanimapplication.service.ServiceResult

interface AnimeSearchRepository {
    suspend fun fetchSearchData(anime: String): ServiceResult<AnimeObject>
}