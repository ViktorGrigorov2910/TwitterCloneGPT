package com.example.twitterclonegpt.ui.homescreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    Scaffold { HomeScreenContent(viewModel) }
}