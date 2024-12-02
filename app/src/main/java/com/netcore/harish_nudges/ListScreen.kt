package com.netcore.harish_nudges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netcore.harish_nudges.ui.theme.Harish_nudgesTheme

class ListScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Harish_nudgesTheme {
                ListScreen()
            }
        }
    }
}

@Composable
internal fun ListScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // LazyColumn provides built-in scrolling behavior
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items((1..50).toList(), key = { it }) { item ->
                // Each list item
                ListItem(item)
                HorizontalDivider(color = Color.LightGray)
            }
        }
    }
}

@Composable
fun ListItem(item: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle item click here */ }
            .padding(16.dp), // Padding around the item
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Text showing the list item
        Text(
            text = "List item $item",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f) // Ensures text fills the available space
        )
    }
}
