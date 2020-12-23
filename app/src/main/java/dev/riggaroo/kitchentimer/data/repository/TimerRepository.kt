package dev.riggaroo.kitchentimer.data.repository

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.data.database.TimerDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.time.Duration
import java.time.ZonedDateTime
import javax.inject.Inject

class TimerRepository @Inject constructor(private val timerDao: TimerDao) {

    fun getListSavedTimers() : Flowable<List<Timer>> {
        return timerDao.getTimers()
    }

    fun addTimer(duration: Duration, name: String?) : Single<Long> {
        return Single.fromCallable {
            val result = timerDao.insertTimer(Timer(durationSeconds = duration.seconds, name = name, lastUsedTime = ZonedDateTime.now()))
            result
        }
    }
}