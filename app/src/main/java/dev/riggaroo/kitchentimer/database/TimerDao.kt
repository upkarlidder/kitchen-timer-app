package dev.riggaroo.kitchentimer.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TimerDao {

    @Query("select * from ${Timer.TABLE_NAME}")
    suspend fun getTimers() : List<Timer>
}