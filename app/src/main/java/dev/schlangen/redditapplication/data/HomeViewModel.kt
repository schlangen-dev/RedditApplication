package dev.schlangen.redditapplication.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val mealAccessor: MealAccessor) : ViewModel() {



    private val counter = MutableStateFlow(0)
    private val meals = MutableStateFlow(emptyList<String>())

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
                meals
            ) { counter, meals ->
                HomeViewState(count = counter, meals = meals)
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
        viewModelScope.launch {
            meals.value = mealAccessor.getRandomMeals()
        }
    }
}

// Data classes in kotlin: https://kotlinlang.org/docs/data-classes.html
data class HomeViewState(
    val count: Int = 0,
    val meals: List<String> = emptyList()
)