package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.Next
import com.spotify.mobius.Update
import dev.riggaroo.kitchentimer.data.database.Timer
import java.time.ZonedDateTime

class TimersModelUpdate : Update<TimersModel, TimersEvent, TimersEffect > {

    override fun update(model: TimersModel, event: TimersEvent): Next<TimersModel, TimersEffect> {
        return when (event) {
            is TimersEvent.AddTimer -> {
                Next.dispatch(setOf(TimersEffect.AddTimer(event.duration, event.name)))
            }
            TimersEvent.TimerAdded -> {
                // No need to trigger model update since TimersLoadedEvent will be triggered again.
                Next.noChange()
            }
            is TimersEvent.LoadTimers -> {
                Next.dispatch(setOf(TimersEffect.LoadTimers))
            }
            is TimersEvent.TimersLoadedEvent -> {
                Next.next(model.copy(timerViewState = TimerViewState.LOADED,
                    timers = event.timers))
            }
            TimersEvent.StartTimer -> TODO()
            TimersEvent.StopTimer -> TODO()
            is TimersEvent.DeleteTimer -> TODO()

        }
    }

}