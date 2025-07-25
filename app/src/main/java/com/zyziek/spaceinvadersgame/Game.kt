package com.zyziek.spaceinvadersgame

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Black //Black background
    ) {
        AndroidAlienRow()
    }
}

@Composable
fun GameOver(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AndroidAlienRow()
        Spacer(
            modifier = Modifier.matchParentSize().background(color = Color.Gray.copy(alpha = .7f))
        )
        Text (
            text = "GAME OVER",
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun AndroidAlienRow() {
    LazyRow() {
        items(4) { index ->
            val isRed = index % 2 == 0
            AndroidAlien(isRed, modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview
@Composable
fun AndroidAlienRowPreview() {
    GameOver()
}
@Composable
fun GameWithInfo(modifier: Modifier ) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            InfoHeader()
        },
        bottomBar = {
            Button(
                onClick = {}
            ) {
                Text(
                    text = "PRESS START",
                    color = Color.White
                )
            }
        }
    ) {
        paddingValues ->
        GameScreen(Modifier.padding(paddingValues))
    }
}

@Composable
fun InfoHeader() {
    Text(
        text = "Info Header Placeholder",
        color = Color.White,
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(8.dp)
    )
}

@Composable
fun AlienGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(5)) {
        items(50) { index ->
            val isRed = index % 2 == 0
            AndroidAlien(isRed, modifier = Modifier.padding(4.dp))
        }
    }
}
@Composable
fun AndroidAlien(
    isRed: Boolean,
    modifier: Modifier = Modifier
) {
    var drawableRes = if (isRed) R.drawable.androidred else R.drawable.androidgreen
    Image(
        modifier = modifier,
        painter = painterResource(id = drawableRes),
        contentDescription = null,
    )
}