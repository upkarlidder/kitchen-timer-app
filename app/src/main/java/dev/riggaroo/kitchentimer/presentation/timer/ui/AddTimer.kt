package dev.riggaroo.kitchentimer.presentation.timer.ui

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddTimerButton(modifier: Modifier, addTimerClicked: () -> Unit) {
    ExtendedFloatingActionButton(modifier = modifier,
        text = {
            Text(text = "Add Timer")
        }, onClick = {
            addTimerClicked()
        })
}