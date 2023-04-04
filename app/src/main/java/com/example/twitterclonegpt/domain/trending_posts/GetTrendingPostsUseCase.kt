package com.example.twitterclonegpt.domain.trending_posts

import com.example.twitterclonegpt.data.TrendingPostsRepositoryContract
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.UseCase
import javax.inject.Inject

class GetTrendingPostsUseCase @Inject constructor(
    private val trendingPostsRepository: TrendingPostsRepositoryContract)
    : UseCase<Unit, DataResult<List<TrendingPost>>> {

    override suspend fun execute(param: Unit): DataResult<List<TrendingPost>> =
        trendingPostsRepository.getTrendingPosts()

}