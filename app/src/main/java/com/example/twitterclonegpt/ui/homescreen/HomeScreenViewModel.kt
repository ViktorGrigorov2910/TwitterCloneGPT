package com.example.twitterclonegpt.ui.homescreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.trending_posts.GetTrendingPostsUseCase
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {
    private val getTrendingPostsUseCase: GetTrendingPostsUseCase = GetTrendingPostsUseCase()

    private val _trendingPostsState = MutableLiveData<TrendingPostState>()
    val trendingPostsState: LiveData<TrendingPostState> = _trendingPostsState
    lateinit var cache: List<TrendingPost>

    init {
        Log.i("Testing" , "In ViewModel")
        fetchTrendingPosts()
    }

    private fun fetchTrendingPosts() {
        if (this::cache.isInitialized) _trendingPostsState.value = TrendingPostState.Success(cache)

        viewModelScope.launch {
            _trendingPostsState.value = TrendingPostState.Loading

            when (val result = getTrendingPostsUseCase.execute(Unit)) {
                is DataResult.Failure -> _trendingPostsState.value =
                    TrendingPostState.Failure(result.error)
                is DataResult.Success -> {
                    cache = result.value
                    _trendingPostsState.value = TrendingPostState.Success(result.value)
                }
            }

        }
    }

    sealed class TrendingPostState() {
        object Loading : TrendingPostState()
        data class Failure(val exception: Exception) : TrendingPostState()
        data class Success(val trendingPosts: List<TrendingPost>) : TrendingPostState()
    }

}