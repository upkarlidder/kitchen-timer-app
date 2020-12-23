package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.presentation.mobius.MobiusEffect
import java.time.Duration

sealed class TimersEffect : MobiusEffect {

    object LoadTimers: TimersEffect()

    data class AddTimer(val duration: Duration, val name: String?): TimersEffect()

    data class DeleteTimer(val timer: Timer): TimersEffect()
}