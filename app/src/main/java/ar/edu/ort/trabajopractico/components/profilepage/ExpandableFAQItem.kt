package ar.edu.ort.trabajopractico.components.profilepage
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import ar.edu.ort.trabajopractico.ui.theme.AppTypography


@Composable
fun ExpandableFAQItem(title: String, content: String) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = AppTypography.sectionTitle
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(
                    id = if (expanded) R.drawable.arrow_up else R.drawable.arrow_down
                ),
                contentDescription = if (expanded) "Collapse" else "Expand",
                modifier = Modifier.size(20.dp),
                tint = Color.Black
            )
        }

        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                style = AppTypography.privacyItem
            )
        }
    }
}

