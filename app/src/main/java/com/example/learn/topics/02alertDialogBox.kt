package com.example.learn.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogBox() {
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var option by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Alert Dialog Demo",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { showDialog = true }) {
            Text("Show Alert")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false // Dismiss when touched outside
                },
                title = {
                    Text(text = "Alert Dialog Box Title")
                },
                text = {
                    Text("This is an alert dialog box. Click OK to show a colored box or Cancel to dismiss it.")
                },
                confirmButton = {
                    TextButton(onClick = {
                        option = true
                        showDialog = false
                    }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        option = false
                        showDialog = false
                    }) {
                        Text("Cancel")
                    }
                }
            )
        }

        if (option) {
            // Get current theme state from MaterialTheme
            val isDarkTheme = MaterialTheme.colorScheme.background ==
                    androidx.compose.material3.darkColorScheme().background
            ColorBox(isDarkTheme = isDarkTheme)
        } else {
            Text(
                text = "Click the button to show the alert dialog box.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}