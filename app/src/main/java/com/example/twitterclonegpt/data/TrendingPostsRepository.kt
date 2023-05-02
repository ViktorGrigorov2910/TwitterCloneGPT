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

    override suspend fun likePost(postId: Int): DataResult<Unit> = asDataResult { dummyTrendingPosts.find { it.id == postId }.also { it?.likeCount = it?.likeCount!! + 1 } }

}


//Dummy Data
// TODO: Remove when have messages
const val TEST_TEXT =
    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type"

val dummyTrendingPosts = mutableStateListOf(
    TrendingPost(id = 374737 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black , username = "johndoe123" , likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 73743 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 1321 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 1328 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 1329 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 13200 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 13297 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 1328567 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 13752 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 8768687 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 46564 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 277484 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 2662362 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 745847 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 623636 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 13848452 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 8446746 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 364346 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 6337226 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 37347345 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3),
    TrendingPost(id = 734737345 , textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black, username = "johndoe123", likeCount = 12 , retweetCount = 3)
)
