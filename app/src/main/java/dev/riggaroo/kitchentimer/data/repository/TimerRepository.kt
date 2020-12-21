package dev.riggaroo.kitchentimer.data.repository

import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.data.database.TimerDao
import java.time.Duration
import java.time.ZonedDateTime
import javax.inject.Inject

class TimerRepository @Inject constructor(private val timerDao: TimerDao) {

    suspend fun getListSavedTimers() : List<Timer> {
        return timerDao.getTimers()
    }

    suspend fun addTimer(duration: Duration, name: String?) {
        timerDao.insertTimer(Timer(durationSeconds = duration.seconds, name = name, lastUsedTime = ZonedDateTime.now()))
    }
}