package com.example.learn.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun ColorBox(isDarkTheme: Boolean,    onThemeChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(0.dp, 10.dp, 20.dp, 16.dp),
        ){// Title
            Text(
                text = "Color Palette - ${if (isDarkTheme) "Dark" else "Light"} Theme",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Switch(
                checked = isDarkTheme,
                onCheckedChange = onThemeChange

            )  }


        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Material Theme Colors Column
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        "Material Theme Colors",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                item {
                    ColorCard("Primary", MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary)
                }
                item {
                    ColorCard("Secondary", MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.onSecondary)
                }
                item {
                    ColorCard("Background", MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.onBackground)
                }
                item {
                    ColorCard("Surface", MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.onSurface)
                }
                item {
                    ColorCard("Surface Variant", MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            // Custom Colors Column
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        "Custom ${if (isDarkTheme) "Dark" else "Light"} Colors",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                if (isDarkTheme) {
                    item { ColorCard("Primary Dark", PrimaryDarkColor, PrimaryDarkText) }
                    item { ColorCard("Secondary Dark", SecondaryDarkColor, PrimaryDarkText) }
                    item { ColorCard("Background Dark", BackgroundDarkColor, PrimaryDarkText) }
                    item { ColorCard("Screen Dark", BackgroundDarkScreenColor, PrimaryDarkText) }
                    item { ColorCard("Primary Text", PrimaryDarkText, SecondaryDarkText) }
                    item { ColorCard("Secondary Text", SecondaryDarkText, PrimaryDarkText) }
                } else {
                    item { ColorCard("Primary Light", PrimaryLightColor, PrimaryLightText) }
                    item { ColorCard("Secondary Light", SecondaryLightColor, PrimaryLightText) }
                    item { ColorCard("Background Light", BackgroundLightColor, PrimaryLightText) }
                    item { ColorCard("Screen Light", BackgroundLightScreenColor, PrimaryLightText) }
                    item { ColorCard("Primary Text", PrimaryLightText, SecondaryLightText) }
                    item { ColorCard("Secondary Text", SecondaryLightText, PrimaryLightText) }
                }
            }
        }
    }
}

@Composable
private fun ColorCard(name: String, backgroundColor: Color, textColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                color = textColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}