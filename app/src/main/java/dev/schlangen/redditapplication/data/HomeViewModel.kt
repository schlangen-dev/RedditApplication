package dev.schlangen.redditapplication.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel() : ViewModel() {

    // Hold onto view state and emits updates when _state.value is updated
    // See: https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
    private val _state = MutableStateFlow(HomeViewState(count = 0))

    val state: StateFlow<HomeViewState>
        get() = _state

    init {

    }
}

// Data classes in kotlin: https://kotlinlang.org/docs/data-classes.html
data class HomeViewState(
    val count: Int
)