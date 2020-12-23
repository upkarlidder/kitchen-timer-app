package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.Next
import com.spotify.mobius.Update
import dev.riggaroo.kitchentimer.data.database.Timer
import java.time.ZonedDateTime

class TimersModelUpdate : Update<TimersModel, TimersEvent, TimersEffect > {

    override fun update(model: TimersModel, event: TimersEvent): Next<TimersModel, TimersEffect> {
        return when (event) {
            is TimersEvent.AddTimer -> {
                // todo invoke db call instead
                val runningList = model.timers.toMutableList()
                val newTimer = Timer(0, event.duration.seconds, event.name, ZonedDateTime.now())
                runningList.add(newTimer)
                Next.next(model.copy(timerViewState = TimerViewState.LOADED,
                        timers = runningList))
            }
            TimersEvent.StartTimer -> TODO()
            TimersEvent.StopTimer -> TODO()
            is TimersEvent.DeleteTimer -> TODO()
        }
    }

}