package dev.schlangen.redditapplication.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.schlangen.redditapplication.data.Recipe

@Composable
fun RecipeWidget(recipe: Recipe) {
    Column(
        Modifier.fillMaxWidth(),
    ) {
        Text(
            text = recipe.title.orEmpty(),
            fontSize = 24.sp,
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
        val numServings = recipe.servings
        Text(
            text = "Serves: $numServings",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        val readyInMinutes = recipe.readyInMinutes
        Text(
            text = "Ready in $readyInMinutes minutes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(all = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Directions",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        Text(
            text = recipe.instructions.orEmpty(),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(all = 20.dp)
        )
    }
}