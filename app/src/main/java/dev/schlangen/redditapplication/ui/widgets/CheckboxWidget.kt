package dev.schlangen.redditapplication.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxWidget(
    checked: Boolean,
    title: String,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp)) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChanged,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = title,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}