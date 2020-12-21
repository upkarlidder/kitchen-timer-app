package dev.riggaroo.kitchentimer.repository

import dev.riggaroo.kitchentimer.database.Timer
import dev.riggaroo.kitchentimer.database.TimerDao
import javax.inject.Inject

class TimerRepository @Inject constructor(private val timerDao: TimerDao) {

    suspend fun getListSavedTimers() : List<Timer> {
        return timerDao.getTimers()
    }
}