package dev.schlangen.redditapplication.data

import androidx.compose.runtime.Stable
import androidx.compose.runtime.toMutableStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@Stable
class HomeViewModel(private val mealAccessor: MealAccessor) : ViewModel() {

    private val recipe = MutableStateFlow<Recipe?>(null)
    private val isBreakfastChecked = MutableStateFlow(false)
    private val isDessertChecked = MutableStateFlow(false)
    private val isVegetarianChecked = MutableStateFlow(false)
    private val isVeganChecked = MutableStateFlow(false)

    // Hold onto view state and emits updates when _state.value is updated
    // See: https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
    private val _state = MutableStateFlow(HomeViewState())

    // Stateflow consumed by the UI
    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(
                recipe,
                isBreakfastChecked,
                isDessertChecked,
                isVegetarianChecked,
                isVeganChecked
            ) { recipe, isBreakfastChecked, isDessertChecked, isVegetarianChecked, isVeganChecked ->
                HomeViewState(
                    recipe = recipe,
                    isBreakfastChecked = isBreakfastChecked,
                    isDessertChecked = isDessertChecked,
                    isVegetarianChecked = isVegetarianChecked,
                    isVeganChecked = isVeganChecked
                )
            }.catch { throwable ->
                println("Failed to combine the HomeViewState")
                throw throwable
            }.collect {
                _state.value = it
            }
        }
    }

    fun onRefreshMeals() {
        println("onRefreshMeals")
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val prefs = mapOf(
                    "breakfast" to isBreakfastChecked.value,
                    "dessert" to isDessertChecked.value,
                    "vegetarian" to isVegetarianChecked.value,
                    "vegan" to isVeganChecked.value
                )
                recipe.value = mealAccessor.getRandomRecipe(prefs)
            }
        }
    }

    // TODO: move to a unified preference event handler
    fun onBreakfastPreferenceClicked(checked: Boolean) {
        viewModelScope.launch {
            isBreakfastChecked.value = checked
        }
    }

    fun onDessertPreferenceClicked(checked: Boolean) {
        viewModelScope.launch {
            isDessertChecked.value = checked
        }
    }

    fun onVegetarionPreferenceClicked(checked: Boolean) {
        viewModelScope.launch {
            isVegetarianChecked.value = checked
        }
    }

    fun onVeganPreferenceClicked(checked: Boolean) {
        viewModelScope.launch {
            isVeganChecked.value = checked
        }
    }
}

// Data classes in kotlin: https://kotlinlang.org/docs/data-classes.html
data class HomeViewState(
    // TODO: default values are redundant with definition for StateFlows above
    val recipe: Recipe? = null,
    val isBreakfastChecked: Boolean = false,
    val isDessertChecked: Boolean = false,
    val isVegetarianChecked: Boolean = false,
    val isVeganChecked: Boolean = false,
)