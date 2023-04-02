package com.example.twitterclonegpt.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.twitterclonegpt.ui.theme.Black


@Composable
fun ShowLoading(isLoading: Boolean) {
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = Black,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp),
            )

        }
    }
}

@Composable
fun ShowError(
    message: String,
    actionLabel: String? = null,
    action: (() -> Unit)? = null,
    duration: SnackbarDuration = SnackbarDuration.Short
) {
    val snackbarHostState = remember { SnackbarHostState() }

    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = {
            Snackbar(
                content = {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onError
                    )
                },
                action = {
                    if (actionLabel != null && action != null) {
                        TextButton(onClick = action) {
                            Text(
                                text = actionLabel,
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.secondary
                            )
                        }
                    }
                },
                backgroundColor = MaterialTheme.colors.error,
            )
        }
    )

    LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar(message = message, duration = duration)
    }
}