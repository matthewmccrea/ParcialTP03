package ar.edu.ort.trabajopractico.screens.profilepage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import ar.edu.ort.trabajopractico.components.profilepage.ExpandableFAQItem
import androidx.compose.foundation.lazy.LazyColumn




@Composable
fun FAQScreen() {
    val faqItems = listOf(
        "Security",
        "How to reset password?",
        "Can I change my email?",
        "What happens if I uninstall the app?",
        "Need support, contact us?"
    )

    val lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris interdum sapien sodales mi sagittis hendrerit. Curabitur ut lectus nec orci cursus rhoncus."

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(faqItems) { title ->
            ExpandableFAQItem(title = title, content = lorem)
        }
    }
}