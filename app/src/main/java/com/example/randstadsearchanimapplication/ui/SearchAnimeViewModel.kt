package com.example.randstadsearchanimapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randstadsearchanimapplication.model.AnimeItem
import com.example.randstadsearchanimapplication.model.AnimeResponse
import com.example.randstadsearchanimapplication.repository.AnimeSearchRepository
import com.example.randstadsearchanimapplication.service.ServiceResult
import kotlinx.coroutines.launch

class SearchAnimeViewModel : ViewModel() {
    private lateinit var animeSearchRepository: AnimeSearchRepository
    private var _animeListData = MutableLiveData<List<AnimeItem?>?>()
    val animeList: LiveData<List<AnimeItem?>?> = _animeListData
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun init(animeRepository: AnimeSearchRepository) {
        this.animeSearchRepository = animeRepository
    }

    /**
     * this method triggers when giving input to search box
     * @param search term to be entered in search box
     */
    fun searchByAnimeTerm(anime: String) {
        if (anime.isNotEmpty()) {
            viewModelScope.launch {
                _isLoading.value = true
                when (
                    val result =
                        animeSearchRepository.fetchSearchData(anime)
                    ) {
                    is ServiceResult.Error -> {
                        _isLoading.value = false
                    }
                    is ServiceResult.Success -> {
                        _isLoading.value = false
                        val response = result.data as AnimeResponse
                        _animeListData.value = response.results
                    }
                }
            }
        } else {
            _animeListData.value = emptyList()
        }
    }
}