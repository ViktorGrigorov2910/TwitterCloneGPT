package com.example.twitterclonegpt.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.domain.trending_posts.TrendingPost
import com.example.twitterclonegpt.ui.messeges.ChatScreenViewModel
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

//TODO: Fix icon placement , the other thins look good
//TODO: Add icons from retweet, share, like , comment
@Composable
fun TrendingItem(item: TrendingPost) {
    Column {
        Divider(
            color = Color.Black,
            thickness = 0.2.dp,)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "@" + item.username,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.textContent,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }


        Divider(
            color = Color.Black,
            thickness = 0.2.dp,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}