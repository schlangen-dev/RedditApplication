package dev.schlangen.redditapplication.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxWidget(checked: Boolean, title: String, onCheckedChanged: (Boolean) -> Unit) {
//    Box(Modifier.background(color = Color(255, 86, 0))
//        .padding(all = 16.dp)
//    ) {
        Row() {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChanged
            )
            Text(
                text = title
            )
        }
//    }
}