package dev.riggaroo.kitchentimer.presentation.timer.list

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import dev.riggaroo.kitchentimer.presentation.mobius.MobiusView
import dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel.TimersViewModel
import dev.riggaroo.kitchentimer.presentation.ui.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MobiusView {

    private val timerViewModel : TimersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitchenTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ListTimersScreen(modifier = Modifier.fillMaxSize()) {
                        timerViewModel
                    }
                }
            }
        }
    }
}

@Composable
fun ListTimersScreen(modifier: Modifier, addTimerClicked: ()-> Unit) {
    Box {
        BackgroundGradient(modifier = modifier)
        AddTimerButton(modifier = Modifier.align(Alignment.BottomCenter)
                .padding(16.dp), addTimerClicked = addTimerClicked)
    }
}

@Composable
fun AddTimerButton(modifier: Modifier, addTimerClicked: () -> Unit) {
    ExtendedFloatingActionButton(modifier = modifier,
            text = {
                Text(text = "Add Timer")
            }, onClick = {
        addTimerClicked()
    })
}

@Composable
fun BackgroundGradient(modifier: Modifier) {
    Canvas(modifier = modifier) {
        val brushBackground = VerticalGradient(
                listOf(orange, peach, lightPurple), 0f, size.height.toDp().toPx(), TileMode.Mirror
        )
        drawRect(brushBackground)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KitchenTimerTheme {

        ListTimersScreen(Modifier.fillMaxSize(), {})
    }
}
*/
