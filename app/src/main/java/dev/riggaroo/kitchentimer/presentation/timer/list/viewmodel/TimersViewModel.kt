package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.android.MobiusLoopViewModel
import dev.riggaroo.kitchentimer.domain.usecase.TimersUseCase
import com.spotify.mobius.runners.WorkRunner
import com.spotify.mobius.rx2.RxMobius
import dev.riggaroo.kitchentimer.presentation.mobius.ViewEffectConsumer
import dev.riggaroo.kitchentimer.presentation.mobius.WorkRunnersConstants
import com.spotify.mobius.functions.Function as MobiusFunction
import javax.inject.Named

class TimersViewModel @ViewModelInject constructor(
        private val timerUseCase: TimersUseCase,
        @Named(WorkRunnersConstants.MAIN_THREAD_WORK_RUNNER) workRunner: WorkRunner
) : MobiusLoopViewModel<TimersModel, TimersEvent, TimersEffect, TimersViewEffect>(
        MobiusFunction<ViewEffectConsumer<TimersViewEffect>, MobiusLoop.Factory<TimersModel, TimersEvent, TimersEffect>> {
            val sideEffectHandler = TimerSideEffectHandler(timerUseCase)
            RxMobius.loop(
                    TimersModelUpdate(),
                    sideEffectHandler
            )
        }, TimersModel(),
        TimersInit(),
        workRunner,
        50
)