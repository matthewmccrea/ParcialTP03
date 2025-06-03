package ar.edu.ort.trabajopractico.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun Dot(isSelected: Boolean, color: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(if (isSelected) 10.dp else 8.dp)
            .clip(RoundedCornerShape(50))
            .background(
                color = if (isSelected) color else color.copy(alpha = 0.3f)
            )
            .clickable { onClick() }
    )
}
