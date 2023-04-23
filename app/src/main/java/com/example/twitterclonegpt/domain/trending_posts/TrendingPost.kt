package com.example.twitterclonegpt.domain.trending_posts

data class TrendingPost(
    val textContent: String,
    val userImage: Int,
    val username: String,
    val likeCount: Int,
    val retweetCount: Int,
)
