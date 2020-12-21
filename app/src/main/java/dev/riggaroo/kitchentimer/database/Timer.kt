package dev.riggaroo.kitchentimer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.riggaroo.kitchentimer.database.Timer.Companion.TABLE_NAME
import java.time.ZonedDateTime

@Entity(tableName = TABLE_NAME)
data class Timer(
    @PrimaryKey
    val id: Int,
    val durationSeconds: Int,
    val name: String,
    val lastUsedTime: ZonedDateTime) {

    companion object {
        const val TABLE_NAME = "timers"
    }
}