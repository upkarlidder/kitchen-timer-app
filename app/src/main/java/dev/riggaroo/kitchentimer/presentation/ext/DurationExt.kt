package dev.riggaroo.kitchentimer.presentation.ext

import java.time.Duration

fun Duration.getFormatted() : String {
    return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
}