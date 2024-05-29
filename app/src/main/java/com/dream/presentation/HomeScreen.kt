package com.dream.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dream.R
import com.dream.utils.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC98A94))
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painterResource(id = R.drawable.stories),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .clickable {
                        navController.navigate(Screen.PageCurl.route)
                    }
            )


            Text(
                text = stringResource(id = R.string.button_story),
                color = Color.Yellow,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
