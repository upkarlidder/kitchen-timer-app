package dev.riggaroo.kitchentimer.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.riggaroo.kitchentimer.data.database.Timer.Companion.TABLE_NAME
import java.time.Duration
import java.time.ZonedDateTime

@Entity(tableName = TABLE_NAME)
data class Timer(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val durationSeconds: Long,
    val name: String? = null,
    val lastUsedTime: ZonedDateTime) {

    companion object {
        const val TABLE_NAME = "timers"
    }

    val duration : Duration
        get() {
            return Duration.ofSeconds(durationSeconds)
        }
}