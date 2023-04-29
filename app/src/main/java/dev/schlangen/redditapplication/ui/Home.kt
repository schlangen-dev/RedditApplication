package dev.schlangen.redditapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.schlangen.redditapplication.data.HomeViewModel
import dev.schlangen.redditapplication.data.Recipe
import dev.schlangen.redditapplication.ui.widgets.CheckboxWidget
import dev.schlangen.redditapplication.ui.widgets.RecipeWidget

@Composable
fun Home(viewModel: HomeViewModel) {
    println("Home()")
    val viewState by viewModel.state.collectAsState()

    Surface(Modifier.fillMaxSize()) {
        println("Surface()")
        HomeContent(
            onRefreshMeals = viewModel::onRefreshMeals,
            onBreakfastPrefChanged = viewModel::onBreakfastPreferenceClicked,
            onDessertPrefChanged = viewModel::onDessertPreferenceClicked,
            onVegetarianPrefChanged = viewModel::onVegetarionPreferenceClicked,
            onVeganPrefChanged = viewModel::onVeganPreferenceClicked,
            recipe = viewState.recipe,
            isBreakfastChecked = viewState.isBreakfastChecked,
            isDessertChecked = viewState.isDessertChecked,
            isVegetarianChecked = viewState.isVegetarianChecked,
            isVeganChecked = viewState.isVeganChecked
        )
    }
}

@Composable
fun HomeContent(
                onRefreshMeals: () -> Unit,
                onBreakfastPrefChanged: (Boolean) -> Unit,
                onDessertPrefChanged: (Boolean) -> Unit,
                onVegetarianPrefChanged: (Boolean) -> Unit,
                onVeganPrefChanged: (Boolean) -> Unit,
                recipe: Recipe?,
                isBreakfastChecked: Boolean,
                isDessertChecked: Boolean,
                isVegetarianChecked: Boolean,
                isVeganChecked: Boolean
) {
    println("HomeContent()")
    Column(Modifier.fillMaxWidth()) {
        Text(text = "Find a Recipe", fontSize = 36.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(all = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)) {
            CheckboxWidget(
                checked = isBreakfastChecked,
                title = "Breakfast",
                onCheckedChanged = { onBreakfastPrefChanged(it) },
            )
            CheckboxWidget(
                checked = isDessertChecked,
                title = "Dessert",
                onCheckedChanged = { onDessertPrefChanged(it) }
            )
        }
        Row() {
            CheckboxWidget(
                checked = isVegetarianChecked,
                title = "Vegetarian",
                onCheckedChanged = { onVegetarianPrefChanged(it) }
            )
            CheckboxWidget(
                checked = isVeganChecked,
                title = "Vegan",
                onCheckedChanged = { onVeganPrefChanged(it) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            Modifier
                .background(color = Color.LightGray)
                .align(Alignment.CenterHorizontally)
                .clickable { onRefreshMeals() } ) {
            Text("New Recipe",
                modifier = Modifier.padding(all = 20.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (recipe != null) {
            RecipeWidget(recipe = recipe)
        }
    }
}