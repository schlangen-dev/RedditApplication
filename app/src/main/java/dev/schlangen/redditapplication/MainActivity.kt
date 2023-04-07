package dev.schlangen.redditapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.schlangen.redditapplication.data.AppContainer
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        appContainer = AppContainer(context)

        setContent {
            RedditApplication(appContainer)
        }
    }
}