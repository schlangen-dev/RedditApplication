package dev.schlangen.redditapplication.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class MealAccessor() {

    // Not a great idea to expose this, but it's a free API with its own throttling
    val API_KEY = "95fb22c4ab654edbbd348da95cc6c498"
    val API_URL = "https://api.spoonacular.com/recipes/random"
    val COMMA_HEX = "%2C"
    val client = OkHttpClient()

    suspend fun getRandomRecipe(currentTags: List<String>) : Recipe {
        println("getRandomMeals()")
        val tagsString = currentTags.joinToString(separator = COMMA_HEX);

        val request = Request.Builder()
            .url("$API_URL?apiKey=$API_KEY&tags=$tagsString")
            .get()
            .build()

        println("getRandomMeals request: $request")
        client.newCall(request).execute().use {response ->
            // TODO: Cleanup
            val bodyString: String? = response.body?.string()
            val jsonObject = JSONObject(bodyString)
            val recipesJson = jsonObject.getJSONArray("recipes")
            val recipeJson = recipesJson.get(0)

            val recipe: Recipe = GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
                .fromJson(recipeJson.toString(), Recipe::class.java)
            println("recipe: $recipe")
            return recipe
        }
    }
}