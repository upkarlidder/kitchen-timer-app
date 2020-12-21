package dev.riggaroo.kitchentimer.domain.usecase

import dev.riggaroo.kitchentimer.data.repository.TimerRepository
import java.time.Duration
import javax.inject.Inject

class TimersUseCase @Inject constructor(val timerRepository: TimerRepository) {

    suspend fun addTimer(duration: Duration, name: String? = null) {
        timerRepository.addTimer(duration = duration, name = name)
    }
}