package com.example.twitterclonegpt.data

import androidx.compose.runtime.mutableStateListOf
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.asDataResult
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost
import kotlinx.coroutines.delay
import javax.inject.Inject

class TrendingPostsRepository @Inject constructor() : TrendingPostsRepositoryContract {

    override suspend fun getTrendingPosts(): DataResult<List<TrendingPost>> = asDataResult {
        delay(3000L)
        dummyTrendingPosts
    }
}


//Dummy Data
// TODO: Remove when have messages
const val TEST_TEXT =
    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type"

val dummyTrendingPosts = mutableStateListOf(
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
    TrendingPost(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black)
)
