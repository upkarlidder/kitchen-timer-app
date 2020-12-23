package dev.riggaroo.kitchentimer.di

import android.content.Context
import androidx.room.Room
import com.spotify.mobius.android.runners.MainThreadWorkRunner
import com.spotify.mobius.runners.WorkRunner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.riggaroo.kitchentimer.data.database.KitchenTimerDatabase
import dev.riggaroo.kitchentimer.data.database.TimerDao
import dev.riggaroo.kitchentimer.presentation.mobius.WorkRunnersConstants
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun provideTimerDatabase(
        @ApplicationContext context: Context
    ): KitchenTimerDatabase {
        return Room.databaseBuilder(
                context,
        KitchenTimerDatabase::class.java, "timers"
        ).build()
    }

    @Provides
    fun provideTimerDao(kitchenTimerDatabase: KitchenTimerDatabase) : TimerDao {
        return kitchenTimerDatabase.getTimerDao()
    }

    @Provides
    @Named(WorkRunnersConstants.MAIN_THREAD_WORK_RUNNER)
    fun providesWorkRunner(): WorkRunner {
        return MainThreadWorkRunner.create()
    }
}
