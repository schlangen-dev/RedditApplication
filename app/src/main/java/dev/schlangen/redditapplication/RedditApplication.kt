package dev.schlangen.redditapplication

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.schlangen.redditapplication.data.AppContainer
import dev.schlangen.redditapplication.data.HomeViewModel
import dev.schlangen.redditapplication.ui.theme.RedditApplicationTheme

@Composable
fun RedditApplication(appContainer: AppContainer) {
    RedditApplicationTheme {
        // A surface container using the 'background' color from the theme
        Home(viewModel = HomeViewModel())
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}