package com.zyziek.spaceinvadersgame.aliens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zyziek.spaceinvadersgame.gameScreen.GameOver
import com.zyziek.spaceinvadersgame.R

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