package dev.schlangen.redditapplication.data

import com.google.gson.annotations.Expose


data class Recipe (
    @Expose(serialize = true, deserialize = true)
    val id: kotlin.Int? = null,
    @Expose(serialize = true, deserialize = true)
    val title: kotlin.String? = null,
    @Expose(serialize = true, deserialize = true)
    val image: kotlin.String? = null,
    @Expose(serialize = true, deserialize = true)
    val imageType: kotlin.String? = null,
    @Expose(serialize = true, deserialize = true)
    val servings: java.math.BigDecimal? = null,
    @Expose(serialize = true, deserialize = true)
    val cheap: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val dairyFree: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val glutenFree: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val instructions: kotlin.String? = null,
    @Expose(serialize = true, deserialize = true)
    val ketogenic: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val vegan: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val vegetarian: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val whole30: kotlin.Boolean? = null,
    @Expose(serialize = true, deserialize = true)
    val summary: kotlin.String? = null,
    @Expose(serialize = true, deserialize = true)
    val cuisines: kotlin.collections.List<kotlin.String>? = null,
    @Expose(serialize = true, deserialize = true)
    val diets: kotlin.collections.List<kotlin.String>? = null,
    @Expose(serialize = true, deserialize = true)
    val occasions: kotlin.collections.List<kotlin.String>? = null,
    @Expose(serialize = true, deserialize = true)
    val dishTypes: kotlin.collections.List<kotlin.String>? = null,
)

