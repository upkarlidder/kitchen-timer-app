package dev.riggaroo.kitchentimer

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TimerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}