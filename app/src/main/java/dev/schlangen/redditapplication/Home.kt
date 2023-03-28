package dev.schlangen.redditapplication

import android.text.Layout
import androidx.compose.foundation.background
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
fun Home(viewModel: HomeViewModel = HomeViewModel()) {

    val viewState by viewModel.state.collectAsState()

    Surface(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxWidth()) {
            val counterText = "Count: ${viewState.count}"
            Text(text = counterText,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 20.dp))
            Box(Modifier
                    .background(color = Color.LightGray)
                    .align(Alignment.CenterHorizontally)) {
                Text("Update",
                    modifier = Modifier.padding(all = 20.dp))
            }
        }
    }
}