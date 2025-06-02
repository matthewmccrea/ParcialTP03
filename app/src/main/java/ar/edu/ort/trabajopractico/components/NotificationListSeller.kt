package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ar.edu.ort.trabajopractico.R

@Composable
fun NotificationListSeller() {
    val items = listOf(
        listOf("You Got New Order!", "Please arrange delivery", R.drawable.icon_notification, null, true),
        listOf("Momon", "Liked your Product", R.drawable.momon, R.drawable.icon_notification, false),
        listOf("Ola", "Liked your Product", R.drawable.ola, R.drawable.icon_notification, false),
        listOf("Raul", "Liked your Product", R.drawable.raul, R.drawable.icon_notification, false),
        listOf("You Got New Order!", "Please arrange delivery", R.drawable.icon_notification, null, true),
        listOf("You Got New Order!", "Please arrange delivery", R.drawable.icon_notification, null, true),
        listOf("You Got New Order!", "Please arrange delivery", R.drawable.icon_notification, null, true),
        listOf("Vito", "Liked your Product", R.drawable.vito, R.drawable.icon_notification, false)
    )

    LazyColumn {
        items(items) { (title, subtitle, startImg, endImg, arrow) ->
            NotificationItem(
                title = title as String,
                subtitle = subtitle as String,
                startImageRes = startImg as Int,
                showArrow = arrow as Boolean,
                endImageRes = endImg as? Int
            )
        }
    }
}