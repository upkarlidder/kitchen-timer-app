package dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel

import com.spotify.mobius.First
import com.spotify.mobius.Init

object TimersInit {

    operator fun invoke() = Init<TimersModel, TimersEffect> { model ->
        First.first(model)
    }
}