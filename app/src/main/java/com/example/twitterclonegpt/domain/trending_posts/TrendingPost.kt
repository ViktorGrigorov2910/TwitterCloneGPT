package com.example.twitterclonegpt.domain.trending_posts

data class TrendingPost(
    val id: Int,
    val textContent: String,
    val userImage: Int,
    val username: String,
    var likeCount: Int,
    var retweetCount: Int,
)
