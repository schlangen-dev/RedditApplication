package dev.schlangen.redditapplication.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MealAccessor() {

    suspend fun getRandomMeals() : List<String> {
        // Should be ready for a real async api cal
        delay(10000)
        return listOf("Burger", "Pizza", "Pasta")
    }

}