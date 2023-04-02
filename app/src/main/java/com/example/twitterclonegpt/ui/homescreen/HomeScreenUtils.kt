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
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.navigation.Screen

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
fun BottomNavigationBar(navController: NavController) = BottomNavigation(
    backgroundColor = MaterialTheme.colors.surface,
    modifier = Modifier.shadow(8.dp)
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigationItem(
        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
        selected = currentRoute == Screen.Home.route,
        onClick = {
            navController.navigate(Screen.Home.route) {
                popStack(this, navController)
            }
        }
    )
    BottomNavigationItem(
        icon = { Icon(Icons.Default.AccountBox, contentDescription = "Messages") },
        selected = currentRoute == Screen.Messages.route,
        onClick = {
            navController.navigate(Screen.Messages.route) {
                popStack(this, navController)
            }
        }
    )
    BottomNavigationItem(
        icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
        selected = currentRoute == Screen.Settings.route,
        onClick = {
            navController.navigate(Screen.Settings.route) {
                popStack(this, navController)
            }
        }
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

private fun popStack(navOptionsBuilder: NavOptionsBuilder, navController: NavController) {
    navOptionsBuilder.apply {
        // Pop up to the start destination of the current nav graph to
        // avoid building up a large stack of destinations
        popUpTo(navController.graph.startDestinationId) {
            // Only pop destinations that are not the home screen
            if (Screen.Home != Screen.Home) {
                saveState = true
            }
        }
        // If the destination is the home screen, close the app
        if (Screen.Home == Screen.Home) {
            launchSingleTop = true
            // This is used to trigger the onBackPressedDispatcher callback
            // in the MainActivity and close the app
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
        }
        //TODO: Add navigation animation
//            anim {
//                enter = R.anim.slide_in_right
//                exit = R.anim.slide_out_left
//            }

        // Clear the back stack when navigating to a new destination
        launchSingleTop = true
        restoreState = true
    }
}