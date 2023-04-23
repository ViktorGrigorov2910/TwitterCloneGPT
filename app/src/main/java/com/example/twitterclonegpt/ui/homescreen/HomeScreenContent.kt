package com.example.twitterclonegpt.ui.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost
import com.example.twitterclonegpt.ui.homescreen.post.TrendingItem
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