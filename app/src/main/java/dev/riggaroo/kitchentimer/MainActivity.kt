package dev.riggaroo.kitchentimer

import android.os.Bundle
import androidx.annotation.Px
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.riggaroo.kitchentimer.ui.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitchenTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting( modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier) {
    BackgroundGradient(modifier = modifier)
}

@Composable
fun BackgroundGradient(modifier: Modifier) {
    Canvas(modifier = modifier) {
        val brushBackground = VerticalGradient(
                listOf(orange, peach, lightPurple), 0f,  size.height.toDp().toPx(), TileMode.Mirror
        )
        drawRect(brushBackground)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KitchenTimerTheme {

        Greeting(Modifier.fillMaxSize())
    }
}