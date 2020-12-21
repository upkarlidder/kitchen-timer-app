package dev.riggaroo.kitchentimer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Timer::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(TimerTypeConverters::class)
abstract class KitchenTimerDatabase  : RoomDatabase() {

    abstract fun getTimerDao() : TimerDao

}