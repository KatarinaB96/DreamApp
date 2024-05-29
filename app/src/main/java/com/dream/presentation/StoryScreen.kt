package com.dream.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.dream.R

@Composable
fun StoryScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(color = Color(0xFFFF69B4), fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            ) {
                append(stringResource(R.string.visit_site))
            }
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://www.daidream.io/"
            )
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Gray, fontSize = 24.sp)) {
                append("https://www.daidream.io/")
            }
            pop()
        }

        ClickableText(
            text = text,
            onClick = { offset ->
                text.getStringAnnotations("URL", offset, offset)
                    .firstOrNull()?.let { annotation ->
                        val url = annotation.item
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        ContextCompat.startActivity(context, intent, null)
                    }
            },
            modifier = Modifier.padding(26.dp)
        )
    }
}