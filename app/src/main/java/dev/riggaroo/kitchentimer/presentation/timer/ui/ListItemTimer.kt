package dev.riggaroo.kitchentimer.presentation.timer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.presentation.ext.getFormatted
import java.time.format.DateTimeFormatter


@Composable
fun ListItemTimer(timer: Timer,
                  timerStarted: (Timer) -> Unit,
                  timerStopped: (Timer) -> Unit,
                  timerDeleted: (Timer)-> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = timer.name ?: "5 min timer",
                style = MaterialTheme.typography.h5)
            val formattedDuration = timer.duration.getFormatted()
            Text(text = formattedDuration,
                style = MaterialTheme.typography.h4)
        }
    }
}