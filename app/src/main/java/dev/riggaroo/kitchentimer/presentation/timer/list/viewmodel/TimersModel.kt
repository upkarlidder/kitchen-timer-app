package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.presentation.mobius.MobiusModel

data class TimersModel(val timerViewState: TimerViewState = TimerViewState.LOADING,
                       val timers: List<Timer> = emptyList()) : MobiusModel


enum class TimerViewState{
    LOADING,
    LOADED,
    ERROR
}