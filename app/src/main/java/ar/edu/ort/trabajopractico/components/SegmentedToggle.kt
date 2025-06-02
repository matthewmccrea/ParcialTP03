package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.ui.theme.fontFamilyPoppins

@Composable
fun SegmentedToggle(
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(Color(0xFFF8F8F8), shape = CircleShape)
            .padding(4.dp)
            .height(36.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        options.forEachIndexed { index, label ->
            val isSelected = index == selectedIndex
            TextButton(
                onClick = { onOptionSelected(index) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        color = if (isSelected) Color(0xFF7140FD) else Color.Transparent,
                        shape = CircleShape
                    ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = label,
                    color = if (isSelected) Color.White else Color(0xFFB3B1B0),
                    fontFamily = fontFamilyPoppins,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}
