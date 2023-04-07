package dev.schlangen.redditapplication

import android.text.Layout
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dev.schlangen.redditapplication.data.HomeViewModel

@Composable
fun Home(viewModel: HomeViewModel) {

    val viewState by viewModel.state.collectAsState()

    Surface(Modifier.fillMaxSize()) {
        HomeContent(
            onIncrementCount = viewModel::onIncrementCount,
            onRefreshMeals = viewModel::onRefreshMeals,
            count = viewState.count,
            meals = viewState.meals)
    }
}

@Composable
fun HomeContent(onIncrementCount: (Int) -> Unit,
                onRefreshMeals: () -> Unit,
                count: Int,
                meals: List<String>) {
    Column(Modifier.fillMaxWidth()) {
        val counterText = "Count: ${count}"
        Text(text = counterText,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(all = 20.dp))
        Box(
            Modifier
                .background(color = Color.LightGray)
                .align(Alignment.CenterHorizontally)
                .clickable { onIncrementCount(1) } ) {
            Text("Update",
                modifier = Modifier.padding(all = 20.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            Modifier
                .background(color = Color.LightGray)
                .align(Alignment.CenterHorizontally)
                .clickable { onRefreshMeals() } ) {
            Text("New meals",
                modifier = Modifier.padding(all = 20.dp))
        }
        meals.forEach{
                meal -> Text(text = meal,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(all = 20.dp))
        }
    }
}