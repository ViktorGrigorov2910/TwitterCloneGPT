package com.example.twitterclonegpt.ui.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitterclonegpt.R

const val TEST_TEXT = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 8.dp,
                modifier = Modifier.height(32.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twitter_icon_black),
                        contentDescription = "Center Icon",
                        modifier = Modifier.size(32.dp),
                        alignment = Alignment.Center
                    )
                }
            }
        } ,
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.surface ,
                modifier = Modifier.shadow(8.dp )
            ) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    selected = true,
                    onClick = { /* TODO */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.AccountBox, contentDescription = "Messages") },
                    selected = true,
                    onClick = { /* TODO */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    selected = true,
                    onClick = { /* TODO */ }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .fillMaxWidth(1f),
            horizontalAlignment = CenterHorizontally

        ) {
            Text(
                text = "Trending Now",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            LazyColumn {
                itemsIndexed(getTrendingNow()) { index, item ->
                    TrendingItem(item = item)
                    if (index != getTrendingNow().size - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun TrendingItem(item: TrendingItemModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically ,
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
            text = item.title,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Left
        )
    }
}



data class TrendingItemModel(val title: String, val imageId: Int)

fun getTrendingNow(): List<TrendingItemModel> {
    return mutableStateListOf(
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black),
        TrendingItemModel(title = TEST_TEXT, imageId = R.drawable.twitter_icon_black)
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()

}