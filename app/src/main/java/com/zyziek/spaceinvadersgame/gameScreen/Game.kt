package com.zyziek.spaceinvadersgame.gameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zyziek.spaceinvadersgame.R
import com.zyziek.spaceinvadersgame.aliens.AlienGrid
import com.zyziek.spaceinvadersgame.aliens.AndroidAlienRow


@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Black //Black background
    ) {
        AlienGrid()
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
@Preview
fun GameWithInfo(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            InfoHeader()
        },
        bottomBar = {
            ElevatedButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier.fillMaxWidth().padding(25.dp),
                shape = RoundedCornerShape(6.dp)

            ) {
                Text(
                    text = "PRESS START",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    ) {
        paddingValues ->
        GameScreen(Modifier.padding(paddingValues))
    }
}

@Composable
@Preview
fun InfoHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "SCORE: 0050",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(end = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "LIVES:",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(end = 12.dp)
            )

            repeat(3) {
                Icon(
                    painter = painterResource(id = R.drawable.androidgreen),
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(horizontal = 2.dp)
                )
            }
        }
    }
}

