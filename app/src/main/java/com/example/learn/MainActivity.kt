package com.example.learn
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.learn.ui.theme.LearnTheme
import kotlinx.coroutines.launch
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTheme {
                var selectedItem by rememberSaveable { mutableIntStateOf(0) }
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Text("Drawer title")
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text("Colors 01topicColors.kt ", fontSize = 20.sp) },
                                selected = false,
                                onClick = {
                                   // showColoredBox = true
                                   // showAlertDialogBox=false
                                   selectedItem=1
                                    scope.launch {
                                        drawerState.close()
                                    }
                                    /* Handle item click */
                                }
                            )
                            NavigationDrawerItem(
                                label = {
                                    Text(
                                        "Alert Dialog 02alertDialogBox.kt ",
                                        fontSize = 20.sp
                                    )
                                },
                                selected = false,
                                onClick = {
                                   // showAlertDialogBox = true
                                    //showColoredBox=false
                                    selectedItem=2
                                    scope.launch {
                                        drawerState.close()
                                    }
                                    /* Handle item click */
                                }
                            )
                            NavigationDrawerItem(
                                label = { Text("Login form 03loginForm.kt ", fontSize = 20.sp) },
                                selected = false,
                                onClick = {
                                    selectedItem=3
                                    scope.launch {
                                        drawerState.close()
                                    }
                                    /* Handle item click */
                                }
                            )
                        }
                    })
                {
                    when (selectedItem) {
                        1 -> {
                            ColorBox()
                        }
                        2 -> {
                            AlertDialogBox()
                        }
                        3 -> {
                            LoginForm()
                        }
                        else -> {
                            Column(
                                modifier = Modifier
                                    .padding(50.dp)
                            ) {
                                Text(
                                    "Click something in the drawer to show on the screen",
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }

                    // logic to show the selected topic from navigation drawer
                }

            }
        }
    }
}

