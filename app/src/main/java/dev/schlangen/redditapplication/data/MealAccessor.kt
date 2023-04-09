package dev.schlangen.redditapplication.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import okhttp3.OkHttpClient
import okhttp3.Request

class MealAccessor() {

    // Not a great idea to expose this, but it's a free API with its own throttling
    val API_KEY = "95fb22c4ab654edbbd348da95cc6c498"
    val API_URL = "https://api.spoonacular.com/recipes/random"
    val COMMA_HEX = "%2C"


    suspend fun getRandomMeals(currentTags: List<String>) : List<String> {
        println("getRandomMeals()")
        // Should be ready for a real async api cal
        delay(3000)
        val client = OkHttpClient()

        val tagsString = currentTags.joinToString(separator = COMMA_HEX);
        println("current tags $currentTags")
        println("tagsString $tagsString")


        val request = Request.Builder()
            .url("$API_URL?apiKey=$API_KEY&tags=$tagsString")
            .get()
            .build()

        println("getRandomMeals request: $request")
        val response = client.newCall(request).execute()
        println("getRandomMeals response: $response")

        // TODO: NEXT - process the response and return it.
        // New plan is to generate random recipe info based on user preferences (tags)
        if (response.isSuccessful) {
            return listOf("Burger", "Pizza", "Pasta", "Curry", "Tacos")
        }
        return listOf("Burger", "Pizza", "Pasta")
    }

}