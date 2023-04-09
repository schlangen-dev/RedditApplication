package dev.schlangen.redditapplication.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.prefs.AbstractPreferences

class HomeViewModel(private val mealAccessor: MealAccessor) : ViewModel() {

    private val counter = MutableStateFlow(0)
    private val meals = MutableStateFlow(emptyList<String>())
    private val preferences = MutableStateFlow(listOf("dessert"))

    // Hold onto view state and emits updates when _state.value is updated
    // See: https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
    private val _state = MutableStateFlow(HomeViewState())

    // Stateflow consumed by the UI
    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(
                counter,
                meals,
                preferences
            ) { counter, meals, preferences ->
                HomeViewState(
                    count = counter,
                    meals = meals,
                    preferences = preferences
                )
            }.catch { throwable ->
                // TODO: handle issues?
                throw throwable
            }.collect {
                _state.value = it
            }
        }
    }

    fun onIncrementCount(amount: Int) {
        println("onIncrementCount");
        viewModelScope.launch {
            counter.value += amount;
        }
    }

    fun onRefreshMeals() {
        println("onRefreshMeals")
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                meals.value = mealAccessor.getRandomMeals(state.value.preferences)
            }
        }
    }
}

// Data classes in kotlin: https://kotlinlang.org/docs/data-classes.html
data class HomeViewState(
    // TODO: default values are redundant with definition for StateFlows above
    val count: Int = 0,
    val meals: List<String> = emptyList(),
    // TODO: control via UI checkboxes
    val preferences: List<String> = listOf("dessert")
)