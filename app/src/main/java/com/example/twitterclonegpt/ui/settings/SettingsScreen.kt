package com.example.twitterclonegpt.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    val isNotificationEnabled = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = isNotificationEnabled.value,
                onCheckedChange = { isNotificationEnabled.value = it }
            )
        }

        Text(
            text = "Option 1",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Option 2",
            style = MaterialTheme.typography.subtitle1,
        )
    }
}
