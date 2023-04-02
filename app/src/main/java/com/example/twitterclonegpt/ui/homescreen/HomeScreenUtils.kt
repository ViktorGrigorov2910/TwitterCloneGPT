package com.example.twitterclonegpt.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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


    when (val state = trendingPostsState.value) {
        is HomeScreenViewModel.TrendingPostState.Success -> {
            LazyColumn  {
                items(state.trendingPosts) { item ->
                    postsListState.value = state.trendingPosts
                    TrendingItem(item = item)
                }
            }
        }
        is HomeScreenViewModel.TrendingPostState.Failure -> {
            state.exception.message?.let { ShowError(message = it) }
        }
        is HomeScreenViewModel.TrendingPostState.Loading -> {
            ShowLoading(true)
        }
        else -> {}
    }
}

@Composable
fun TrendingItem(item: TrendingPost) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .border(0.8.dp, Color.Black, RectangleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.twitter_icon_black),
            contentDescription = "Center Icon",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterStart
        )
        Text(
            text = item.textContent,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Left
        )
    }
}