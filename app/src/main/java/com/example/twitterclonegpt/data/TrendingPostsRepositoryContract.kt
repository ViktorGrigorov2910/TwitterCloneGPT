package com.example.twitterclonegpt.data

import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost

interface TrendingPostsRepositoryContract {

    suspend fun getTrendingPosts(): DataResult<List<TrendingPost>>

}