package dev.riggaroo.kitchentimer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TimerDao {

    @Query("select * from ${Timer.TABLE_NAME}")
    suspend fun getTimers() : List<Timer>

    @Insert
    suspend fun insertTimer(timer: Timer)
}