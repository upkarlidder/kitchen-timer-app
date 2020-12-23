package dev.riggaroo.kitchentimer.presentation.timer.list

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import dagger.hilt.android.AndroidEntryPoint
import dev.riggaroo.kitchentimer.data.database.Timer
import dev.riggaroo.kitchentimer.presentation.mobius.MobiusView
import dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel.TimersEvent
import dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel.TimersModel
import dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel.TimersViewEffect
import dev.riggaroo.kitchentimer.presentation.timer.list.viewmodel.TimersViewModel
import dev.riggaroo.kitchentimer.presentation.timer.ui.AddTimerButton
import dev.riggaroo.kitchentimer.presentation.timer.ui.BackgroundGradient
import dev.riggaroo.kitchentimer.presentation.timer.ui.ListItemTimer
import dev.riggaroo.kitchentimer.presentation.ui.*
import java.time.Duration
import kotlin.random.Random

@AndroidEntryPoint
class TimersActivity : AppCompatActivity(), MobiusView<TimersModel, TimersViewEffect> {

    private val timerViewModel : TimersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitchenTimerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ListTimersScreen(model = timerViewModel.models, modifier = Modifier.fillMaxSize()) {
                        timerViewModel.dispatchEvent(TimersEvent.AddTimer(Duration.ofMinutes(Random.nextLong(10)), "Test Timer"))
                    }
                }
            }
        }
        subscribeToViewEffects(this, timerViewModel)
        timerViewModel.dispatchEvent(TimersEvent.LoadTimers)
    }

    override fun handleViewEffect(viewEffect: TimersViewEffect) {

    }
}

@Composable
fun ListTimersScreen(model: LiveData<TimersModel>, modifier: Modifier, addTimerClicked: ()-> Unit) {
    Box {
        BackgroundGradient(modifier = modifier)
        AddTimerButton(modifier = Modifier.align(Alignment.BottomCenter)
                .padding(16.dp), addTimerClicked = addTimerClicked)
        val state : TimersModel? by model.observeAsState()
        state?.let { model ->
            LazyColumn(Modifier.fillMaxWidth().padding(8.dp)) {
                items(model.timers) {
                    ListItemTimer(it)
                }
            }
        }
    }
}


/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KitchenTimerTheme {

        ListTimersScreen(Modifier.fillMaxSize(), {})
    }
}*/
