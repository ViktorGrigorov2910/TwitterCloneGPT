package com.example.twitterclonegpt.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
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