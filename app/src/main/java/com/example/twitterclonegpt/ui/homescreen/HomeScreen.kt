package com.example.twitterclonegpt.ui.homescreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.twitterclonegpt.R

// TODO: Remove when have messages
const val TEST_TEXT =
    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) { HomeScreenContent() }
}

data class TrendingItemModel(val textContent: String, val userImage: Int)

fun getTrendingNow(): List<TrendingItemModel> {
    return mutableStateListOf(
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black),
        TrendingItemModel(textContent = TEST_TEXT, userImage = R.drawable.twitter_icon_black)
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}