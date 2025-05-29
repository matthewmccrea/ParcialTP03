package ar.edu.ort.trabajopractico.components.profilepage
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun ActionTabs(
    tabs: List<String>,
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        tabs.forEach { tab ->
            val isSelected = tab == selectedTab
            TextButton(
                onClick = { onTabSelected(tab) },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF7140FD) else Color(0xFFF5F5F5),
                    contentColor = if (isSelected) Color.White else Color(0xFF9E9E9E)
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp)
            ) {
                Text(
                    text = tab,
                    style = if (isSelected) AppTypography.tabSelected else AppTypography.tabUnselected
                )
            }
        }
    }
}
