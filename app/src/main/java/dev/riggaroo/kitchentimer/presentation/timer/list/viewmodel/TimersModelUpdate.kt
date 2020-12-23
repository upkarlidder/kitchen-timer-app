package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.Next
import com.spotify.mobius.Update

class TimersModelUpdate : Update<TimersModel, TimersEvent, TimersEffect > {

    override fun update(model: TimersModel, event: TimersEvent): Next<TimersModel, TimersEffect> {
        return when (event) {
            is TimersEvent.AddTimer -> {
                Next.next(model)
            }
            TimersEvent.StartTimer -> TODO()
            TimersEvent.StopTimer -> TODO()
            is TimersEvent.DeleteTimer -> TODO()
        }
    }

}