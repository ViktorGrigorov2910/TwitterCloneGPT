package com.example.twitterclonegpt.ui.homescreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.twitterclonegpt.R

@Composable
fun AppBar() = TopAppBar(
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

@Composable
fun BottomNavigationBar() = BottomNavigation(
    backgroundColor = MaterialTheme.colors.surface,
    modifier = Modifier.shadow(8.dp)
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

@Composable
fun HomeScreenContent() = Column(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .fillMaxWidth(1f),
    horizontalAlignment = Alignment.CenterHorizontally

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

@Composable
fun TrendingItem(item: TrendingItemModel) {
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