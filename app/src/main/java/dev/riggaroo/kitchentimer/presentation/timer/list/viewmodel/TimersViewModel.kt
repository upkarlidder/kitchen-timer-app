package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.spotify.mobius.android.MobiusLoopViewModel
import dev.riggaroo.kitchentimer.domain.usecase.TimersUseCase

class TimersViewModel @ViewModelInject constructor(private val timerUseCase: TimersUseCase)
    : MobiusLoopViewModel<TimersModel, TimersEvent, TimersEffect, TimersViewEffect>(
    modelToStartFrom = TimersModel(),
    loopFactoryProvider = Function { consumer ->
        val sideEffectHandler = TimerSideEffectHandler(timerUseCase)
        RxMobius.loop(
            EditorExportModelUpdate(),
            sideEffectHandler
        )
    }
)