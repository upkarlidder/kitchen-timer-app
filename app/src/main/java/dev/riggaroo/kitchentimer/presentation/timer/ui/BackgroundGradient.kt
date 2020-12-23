package dev.riggaroo.kitchentimer.presentation.timer.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import dev.riggaroo.kitchentimer.presentation.ui.lightPurple
import dev.riggaroo.kitchentimer.presentation.ui.orange
import dev.riggaroo.kitchentimer.presentation.ui.peach

@Composable
fun BackgroundGradient(modifier: Modifier) {
    Canvas(modifier = modifier) {
        val brushBackground = Brush.verticalGradient(
            listOf(orange, peach, lightPurple), 0f, size.height.toDp().toPx(), TileMode.Mirror
        )
        drawRect(brushBackground)
    }
}