package com.example.twitterclonegpt.domain.trending_posts

import com.example.twitterclonegpt.data.TrendingPostsRepository
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.UseCase

class GetTrendingPostsUseCase(private val trendingPostsRepository: TrendingPostsRepository = TrendingPostsRepository()) :
    UseCase<Unit, DataResult<List<TrendingPost>>> {

    override suspend fun execute(param: Unit): DataResult<List<TrendingPost>> =
        trendingPostsRepository.getTrendingPosts()

}