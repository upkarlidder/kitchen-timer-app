package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.rx2.RxMobius
import dev.riggaroo.kitchentimer.domain.usecase.TimersUseCase
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

object TimerSideEffectHandler {

    operator fun invoke(timersUseCase: TimersUseCase): ObservableTransformer<TimersEffect, TimersEvent> {
        val effectHandlerBuilder =
            RxMobius.subtypeEffectHandler<TimersEffect, TimersEvent>()
        effectHandlerBuilder.addTransformer(
            TimersEffect.LoadTimers::class.java,
            loadTimers(timersUseCase)
        )
        effectHandlerBuilder.addTransformer(
            TimersEffect.AddTimer::class.java,
            addTimer(timersUseCase)
        )
        return effectHandlerBuilder.build()
    }

    private fun loadTimers(timersUseCase: TimersUseCase) = ObservableTransformer<TimersEffect.LoadTimers, TimersEvent> { upstream ->
        upstream.flatMap {
            timersUseCase.getTimers()
                .toObservable()
                .map {
                    TimersEvent.TimersLoadedEvent(it)
                }
        }
    }

    private fun addTimer(timersUseCase: TimersUseCase) = ObservableTransformer<TimersEffect.AddTimer, TimersEvent> { upstream ->
        upstream.flatMap { effect ->
            timersUseCase.addTimer(effect.duration, effect.name)
                .map {
                    TimersEvent.TimerAdded
                }
                .toObservable()
        }

    }

}