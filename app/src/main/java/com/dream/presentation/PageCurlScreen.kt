package com.dream.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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

        ClickOnceButton(onClick = {
            navController.popBackStack()
        }) {

            Image(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "Back Arrow",
                modifier = Modifier.size(34.dp)
            )
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

@Composable
fun ClickOnceButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    conditional: () -> Boolean = { true },
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        Color.Transparent
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    var onClickHasExecuted by remember { mutableStateOf(false) }

    Button(
        onClick = {
            if (conditional() && !onClickHasExecuted) {
                onClickHasExecuted = true
                onClick()
            }
        },
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = buttonColors,
        contentPadding = contentPadding,
        content = content
    )
}