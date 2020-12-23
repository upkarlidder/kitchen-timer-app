package dev.riggaroo.kitchentimer.domain.usecase

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.data.repository.TimerRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.time.Duration
import javax.inject.Inject

class TimersUseCase @Inject constructor(val timerRepository: TimerRepository) {

    fun addTimer(duration: Duration, name: String? = null) : Single<Long> {
        return timerRepository.addTimer(duration = duration, name = name)
    }

    fun getTimers() : Flowable<List<Timer>> {
        return timerRepository.getListSavedTimers()
    }
}