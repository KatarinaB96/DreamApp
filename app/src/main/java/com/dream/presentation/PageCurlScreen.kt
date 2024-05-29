package com.dream.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dream.R
import eu.wewox.pagecurl.ExperimentalPageCurlApi
import eu.wewox.pagecurl.page.PageCurl
import eu.wewox.pagecurl.page.rememberPageCurlState

@OptIn(ExperimentalPageCurlApi::class)
@Composable
fun PageCurlScreen(navController: NavController) {
    val state = rememberPageCurlState()
    val pages = listOf(
        stringResource(R.string.lost_kitten),
        stringResource(R.string.brave_turtle),
        stringResource(R.string.magic_carrot)
    )
    val stories = listOf(
        stringResource(R.string.story_lost_kitten),
        stringResource(R.string.story_brave_turtle),
        stringResource(R.string.story_magic_carrot)
    )
    val images = listOf(
        painterResource(R.drawable.story1),
        painterResource(R.drawable.story2_image),
        painterResource(R.drawable.story3)
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PageCurl(
            count = pages.size,
            state = state,
        ) { index ->
            StoryPage(title = pages[index], story = stories[index], image = images[index])
        }
        Button(
            onClick = {
                 navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text("<")
        }
    }

}

@Composable
fun StoryPage(title: String, story: String, image: Painter) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Column {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ), modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = story,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}