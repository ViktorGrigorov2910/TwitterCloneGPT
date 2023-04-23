package com.example.twitterclonegpt.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost
import com.example.twitterclonegpt.ui.utils.ShowError
import com.example.twitterclonegpt.ui.utils.ShowLoading

@Composable
fun HomeScreenContent(viewModel: HomeScreenViewModel) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .fillMaxWidth(1f),
    horizontalAlignment = Alignment.CenterHorizontally

) {
    val trendingPostsState = viewModel.trendingPostsState.observeAsState()
    val postsListState = remember {
        mutableStateOf(emptyList<TrendingPost>())
    }

    Text(
        text = "Trending Now",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp),
        fontSize = 18.sp
    )

    ShowLoading(isLoading = trendingPostsState.value is HomeScreenViewModel.TrendingPostState.Loading)

    when (val state = trendingPostsState.value) {
        is HomeScreenViewModel.TrendingPostState.Success -> {
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(state.trendingPosts) { item ->
                    postsListState.value = state.trendingPosts
                    TrendingItem(item = item)
                }
            }
        }
        is HomeScreenViewModel.TrendingPostState.Failure -> {
            state.exception.message?.let { ShowError(message = it) }
        }
        is HomeScreenViewModel.TrendingPostState.Loading -> Unit
        else -> {}
    }
}

//TODO: Add icons from retweet, share, like , comment
@Composable
fun TrendingItem(item: TrendingPost) {
    Column {
        CustomDivider()
        ContentBox(post = item)
        CustomDivider(modifier = Modifier.padding(top = 4.dp))
    }
}

//Container which holds the image and the text
@Composable
fun ContentBox(post: TrendingPost) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.95f) // Updated fraction to center content
            .background(Color.White)
            .padding(start = 16.dp) // Added padding to the left side
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileImage()
            Spacer(modifier = Modifier.width(16.dp))
            PostContent(post = post)
        }
    }
}

//Profile icon that is shown on the left side of the tweet
@Composable
fun ProfileImage() {
    Column {
        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.twitter_icon_black),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(12.dp)),
            alignment = Alignment.CenterStart
        )
    }
}

//The tweet(text + username)
@Composable
fun PostContent(post: TrendingPost) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "@" + post.username,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = post.textContent,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun CustomDivider(modifier: Modifier = Modifier) {
    Divider(
        color = Color.Black,
        thickness = 0.2.dp,
        modifier = modifier
    )
}