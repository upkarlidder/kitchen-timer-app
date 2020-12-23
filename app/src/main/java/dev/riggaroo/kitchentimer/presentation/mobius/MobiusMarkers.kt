package dev.riggaroo.kitchentimer.presentation.mobius

import com.spotify.mobius.functions.Consumer

interface MobiusView

interface MobiusEffect

interface MobiusViewEffect

interface MobiusEvent

interface MobiusModel

typealias ViewEffectConsumer<T> = Consumer<T>