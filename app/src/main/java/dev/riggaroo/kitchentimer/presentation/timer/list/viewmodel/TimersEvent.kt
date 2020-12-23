package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.presentation.mobius.MobiusEvent
import java.time.Duration

sealed class TimersEvent : MobiusEvent {

    data class AddTimer(val duration: Duration, val name: String? = null) : TimersEvent()
    object StartTimer : TimersEvent()
    object StopTimer : TimersEvent()
    data class DeleteTimer(val timer: Timer): TimersEvent()

}
