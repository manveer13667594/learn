package com.example.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn.topics.AlertDialogBox
import com.example.learn.topics.ColorBox
import com.example.learn.topics.LoginForm
import com.example.learn.topics.SwitchLight
import com.example.learn.ui.theme.LearnTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Global theme state - this controls the entire app's theme
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }

            LearnTheme(darkTheme = isDarkTheme) {
                var selectedItem by rememberSaveable { mutableIntStateOf(0) }
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                // Main container with proper background
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            ModalDrawerSheet {
                                Text(
                                    "Learn App Topics",
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(16.dp)
                                )
                                HorizontalDivider()
                                NavigationDrawerItem(
                                    label = { Text("Colors 01topicColors.kt ", fontSize = 20.sp) },
                                    selected = selectedItem == 1,
                                    onClick = {
                                        selectedItem = 1
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                                NavigationDrawerItem(
                                    label = {
                                        Text(
                                            "Alert Dialog 02alertDialogBox.kt ",
                                            fontSize = 20.sp
                                        )
                                    },
                                    selected = selectedItem == 2,
                                    onClick = {
                                        selectedItem = 2
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                                NavigationDrawerItem(
                                    label = { Text("Login form 03loginForm.kt ", fontSize = 20.sp) },
                                    selected = selectedItem == 3,
                                    onClick = {
                                        selectedItem = 3
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                                NavigationDrawerItem(
                                    label = { Text("Theme Switch 04Switch.kt ", fontSize = 20.sp) },
                                    selected = selectedItem == 4,
                                    onClick = {
                                        selectedItem = 4
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                        })
                    {
                        // Content area with proper background
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background)
                        ) {
                            when (selectedItem) {
                                1 -> {
                                    ColorBox(isDarkTheme = isDarkTheme)
                                }
                                2 -> {
                                    AlertDialogBox()
                                }
                                3 -> {
                                    LoginForm()
                                }
                                4 -> {
                                    // Pass the theme state and setter to SwitchLight
                                    SwitchLight(
                                        isDarkTheme = isDarkTheme,
                                        onThemeChange = { isDarkTheme = it }
                                    )
                                }
                                else -> {
                                    Column(
                                        modifier = Modifier
                                            .padding(50.dp)
                                    ) {
                                        Text(
                                            "Click something in the drawer to show on the screen",
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}