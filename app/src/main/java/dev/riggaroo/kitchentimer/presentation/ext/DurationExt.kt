package dev.riggaroo.kitchentimer.presentation.ext

import java.time.Duration

fun Duration.getFormatted() : String {
    return if (seconds / 3600 > 0) {
        String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
    } else {
        String.format("%02d:%02d", (seconds % 3600) / 60, (seconds % 60));
    }
}