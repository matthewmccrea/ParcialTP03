package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ar.edu.ort.trabajopractico.R

@Composable
fun NotificationListActivity() {
    val items = List(4) { "SALE 50%" }
    LazyColumn {
        items(items) { item ->
            NotificationItem(
                title = item,
                subtitle = "Check the details!",
                startImageRes = R.drawable.icon_notification
            )
        }
    }
}