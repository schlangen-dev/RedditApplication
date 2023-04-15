package dev.schlangen.redditapplication.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.schlangen.redditapplication.data.Recipe

@Composable
fun RecipeWidget(recipe: Recipe) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Text(
            text = recipe.title.orEmpty(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(all = 20.dp)
        )
        AsyncImage(
            model = recipe.image,
            contentDescription = recipe.summary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(all = 20.dp)
        )
    }
}