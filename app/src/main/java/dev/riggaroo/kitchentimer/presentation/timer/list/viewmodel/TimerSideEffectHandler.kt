package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.rx2.RxMobius
import dev.riggaroo.kitchentimer.domain.usecase.TimersUseCase
import io.reactivex.ObservableTransformer

object TimerSideEffectHandler {

    operator fun invoke(timersUseCase: TimersUseCase): ObservableTransformer<TimersEffect, TimersEvent> {
        val effectHandlerBuilder =
            RxMobius.subtypeEffectHandler<TimersEffect, TimersEvent>()
       /* effectHandlerBuilder.addTransformer(
            ProjectListEffect.SyncProjectsListEffect::class.java,
            getSyncProjectsListSideEffectHandler(projectSyncUseCase)
        )*/
        return effectHandlerBuilder.build()
    }

}