package dev.riggaroo.kitchentimer.data.database

import androidx.room.TypeConverter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object TimerTypeConverters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toZonedDateTime(value: String?): ZonedDateTime? {
        return value?.let {
            return formatter.parse(value, ZonedDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromZonedDateTime(date: ZonedDateTime?): String? {
        return date?.format(formatter)
    }
}