package dev.riggaroo.kitchentimer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface TimerDao {

    @Query("select * from ${Timer.TABLE_NAME}")
    fun getTimers() : Flowable<List<Timer>>

    @Insert
    fun insertTimer(timer: Timer): Long
}