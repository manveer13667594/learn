package com.example.learn.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learn.ui.theme.BackgroundDarkColor
import com.example.learn.ui.theme.BackgroundDarkScreenColor
import com.example.learn.ui.theme.BackgroundLightColor
import com.example.learn.ui.theme.BackgroundLightScreenColor
import com.example.learn.ui.theme.PrimaryDarkColor
import com.example.learn.ui.theme.PrimaryDarkText
import com.example.learn.ui.theme.PrimaryLightColor
import com.example.learn.ui.theme.PrimaryLightText
import com.example.learn.ui.theme.SecondaryDarkColor
import com.example.learn.ui.theme.SecondaryDarkText
import com.example.learn.ui.theme.SecondaryLightColor
import com.example.learn.ui.theme.SecondaryLightText

@Composable
fun ColorBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyColumn {
            items(1) {
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(PrimaryDarkColor)
                ) {
                    Text(
                        "PrimaryDarkColor",
                        color = PrimaryDarkText
                    )// Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(SecondaryDarkColor)
                ) {
                    Text(
                        "SecondaryDarkColor",
                        color = PrimaryDarkText
                    ) // Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(BackgroundDarkColor)
                ) {
                    Text(
                        "BackgroundDarkColor",
                        color = PrimaryDarkText
                    ) // Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(BackgroundDarkScreenColor)
                ) {
                    Text(
                        "BackgroundDarkScreenColor",
                        color = PrimaryDarkText
                    )// Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(PrimaryDarkText)
                ) {
                    Text(
                        "PrimaryDarkText",
                        color = SecondaryDarkText
                    )
                    // Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(SecondaryDarkText)
                ) {
                    Text(
                        "SecondaryDarkText",
                        color = PrimaryDarkText
                    )
                    // Content goes here
                }
            }
        }
        LazyColumn {
            items(1) {
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(PrimaryLightColor)
                ) {
                    Text(
                        "PrimaryLightColor",
                        color = PrimaryLightText
                    )// Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(SecondaryLightColor)
                ) {
                    Text(
                        "SecondaryLightColor",
                        color = PrimaryLightText
                    ) // Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(BackgroundLightColor)
                ) {
                    Text(
                        "BackgroundLightColor",
                        color = PrimaryLightText
                    ) // Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(BackgroundLightScreenColor)
                ) {
                    Text(
                        "BackgroundLightScreenColor",
                        color = PrimaryLightText
                    )// Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(PrimaryLightText)
                ) {
                    Text(
                        "PrimaryLightText",
                        color = SecondaryLightText
                    )// Content goes here
                }
                Box(
                    modifier = Modifier
//          .fillMaxSize()
                        .size(100.dp)
                        .background(SecondaryLightText)
                ) {
                    Text(
                        "SecondaryLightColor",
                        color = PrimaryLightText
                    ) // Content goes here
                }
            }
        }
    }
}

